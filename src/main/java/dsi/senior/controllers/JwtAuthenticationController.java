package dsi.senior.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import dsi.senior.cnf.JwtTokenUtil;
import dsi.senior.entities.DAOUser;
import dsi.senior.entities.ERole;
import dsi.senior.entities.JwtRequest;
import dsi.senior.entities.JwtResponse;
import dsi.senior.entities.Role;
import dsi.senior.message.ResponseMessage;
import dsi.senior.repositories.RoleDao;
import dsi.senior.repositories.UserDao;
import dsi.senior.services.JwtUserDetailsService;
import dsi.senior.services.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import request.SignupRequest;

@CrossOrigin
@RestController
@RequestMapping
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	PasswordEncoder encoder;
	

	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtTokenUtil.generateToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(),
												 userDetails.getUsername(),
												 userDetails.getEmail(), 
												 roles));
	}

	
	
	@PostMapping("/signup")
	  public ResponseEntity<?> saveUser(@Valid @RequestBody SignupRequest signUpRequest) throws Exception {
	    if (userDao.existsByUsername(signUpRequest.getUsername())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new ResponseMessage("Error: Username is already taken!"));
	    }

	    if (userDao.existsByEmail(signUpRequest.getEmail())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new ResponseMessage("Error: Email is already in use!"));
	    }

	    // Create new user's account
	    DAOUser user = new DAOUser(signUpRequest.getUsername(), 
	               signUpRequest.getEmail(),
	               encoder.encode(signUpRequest.getPassword()));
	    System.out.println(signUpRequest.getRole());

	    Set<String> strRoles = signUpRequest.getRole();
	    Set<Role> roles = new HashSet<>();

	    if (strRoles == null) {
	      Role userRole = roleDao.findByName(ERole.ROLE_USER)
	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	      roles.add(userRole);
	    } else {
	      strRoles.forEach(role -> {
	        switch (role) {
	        case "admin":
	          Role adminRole = roleDao.findByName(ERole.ROLE_ADMIN)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(adminRole);

	          break;
	        case "accomp":
	          Role modRole = roleDao.findByName(ERole.ROLE_ACCOMPAGNANT)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(modRole);

	          break;
	        default:
	          Role userRole = roleDao.findByName(ERole.ROLE_USER)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(userRole);
	        }
	      });
	    }

	    user.setRoles(roles);
	    userDao.save(user);

	    return ResponseEntity.ok(new ResponseMessage("User registered successfully!"));
	  }

	
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/init")
	@ResponseBody
	    public void initRoleAndUser() {
		   userDetailsService.initRoleAndUser();
	    }
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/currentUser")
	@ResponseBody
	private UserDetails currentUser() throws Exception {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//String username = userDetails.getUsername();
		return userDetails;
	}
	
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/detailsuser")
	@ResponseBody
	private String DetailsUser() throws Exception {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String password = userDetails.toString();
		return password;
	}
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@PutMapping("/update-user")
  	@ResponseBody
  	public ResponseEntity<String> updateRentAnnonce(@RequestBody DAOUser user) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		userDetailsService.UpdateAccountUserByUsername(username, user);
  		return new ResponseEntity<String>("Piece updated successfully",HttpStatus.OK);
  		
  	}
	@CrossOrigin(origins = {"http://localhost:4200"} ,methods = {RequestMethod.GET})
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@GetMapping(value = "/retrieves-all-users")
	@ResponseBody	
	public List<DAOUser> getUsers() {
		List<DAOUser> list = userDetailsService.retreiveAllUsers();
		return list;
	}
	@GetMapping(value = "/UserById/{id}")
	@ResponseBody
	public DAOUser getUserById(@PathVariable("id") int id) {
		return userDetailsService.findById(id);
	}
	@CrossOrigin(origins = {"http://localhost:4200"} ,methods = {RequestMethod.DELETE})
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@DeleteMapping("/delete-user/{id}")
  	@ResponseBody
  	public ResponseEntity<String>  deleteRenting(@PathVariable("id")int id) {
		userDetailsService.DeleteUser(id);
  	    return new ResponseEntity<String>("Piece deleted successfully",HttpStatus.ACCEPTED);
  		
  	}

}