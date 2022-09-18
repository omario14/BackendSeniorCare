package dsi.senior.controllers;

import java.io.File;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
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
import dsi.senior.services.MailService;
import dsi.senior.services.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import request.MailRequest;
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
	@Autowired
	MailService mailservice;
 
	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtTokenUtil.generateToken(authentication);
		DAOUser userr= userDao.findByUsername(authenticationRequest.getUsername());
		userr.setConnected(true);
		userDao.save(userr);
		long expiresIn = (jwtTokenUtil.getExpirationDateFromToken(jwt).getTime()-(System.currentTimeMillis()));
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(new JwtResponse(expiresIn,
												 jwt,
												 userDetails.getId(),
												 userDetails.getName(),
												 userDetails.getLastName(),
												 userDetails.getUsername(),
												 userDetails.getEmail(), 
												 userDetails.getMobile(), 
												 userDetails.getGender(),
												 userDetails.getAdress(),
												 userDetails.getPicture(),
												 userDetails.getRoles(),
												 userr.getConnected(),
												 userDetails.getPassword()));
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
	    DAOUser user = new DAOUser(
	    		signUpRequest.getName(),
	    		signUpRequest.getLastName(),	    		
	    		signUpRequest.getUsername(), 
	               signUpRequest.getEmail(),
	               encoder.encode(signUpRequest.getPassword()),
	               signUpRequest.getMobile(),
	               signUpRequest.getGender(),
	               signUpRequest.getAdress(),
	               signUpRequest.getPicture()
	               );
	    System.out.println(signUpRequest.toString());

	    Set<String> strRoles = signUpRequest.getRole();
	    System.out.println("this is the set of rolesaaaaaaaaaaa "+strRoles);
	    Set<Role> roles = new HashSet<>();

	    if (strRoles.isEmpty()) {
	      Role userRole = roleDao.findByName(ERole.ROLE_CHEF)
	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	      roles.add(userRole);
	    } else {
	      strRoles.forEach(role -> {
	        switch (role) {
	        case "ROLE_ADMIN":
	          Role adminRole = roleDao.findByName(ERole.ROLE_ADMIN)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(adminRole);

	          break;
	        case "ROLE_ACCOMPAGNANT":
	          Role modRole = roleDao.findByName(ERole.ROLE_ACCOMPAGNANT)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(modRole);

	          break;
	        default:
	          Role userRole = roleDao.findByName(ERole.ROLE_CHEF)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(userRole);
	        }
	      });
	    }

	    user.setRoles(roles);
	    userDao.save(user);
	    MailRequest request = new MailRequest(signUpRequest.getUsername(),signUpRequest.getEmail(),"omar.benamor@esprit.tn","Welcome");
	    
	    Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("body", signUpRequest.getPassword());
		model.put("firstName", signUpRequest.getName());
		
	
	    mailservice.sendEmail(request, model);
	   
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
	@PutMapping("/update-user/{id}")
  	@ResponseBody
  	public ResponseEntity<String> updateUser(@PathVariable("id") int id, @RequestBody DAOUser user) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		userDetailsService.UpdateAccountUserByUsername(id, user);
  		return new ResponseEntity<String>("User updated successfully",HttpStatus.OK);
  		
  	}
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@PutMapping("/update-user-profile/{id}/{jwtokl}")
  	@ResponseBody
  	public ResponseEntity<?> updateUserProfile(@PathVariable("id") int id,@PathVariable("jwtokl") String jwtokl, @RequestBody DAOUser user) throws Exception {
		DAOUser u =userDetailsService.UpdateAccountUserByUsername(id, user);
		long expiresIn = (jwtTokenUtil.getExpirationDateFromToken(jwtokl).getTime()-(System.currentTimeMillis()));
		
		return ResponseEntity.ok(new JwtResponse(expiresIn,
				jwtokl,
				 u.getId(),
				 u.getName(),
				 u.getLastName(),
				 u.getUsername(),
				 u.getEmail(), 
				 u.getMobile(), 
				 u.getGender(),
				 u.getAdress(),
				 u.getPicture(),
				 u.getRoles(),
				 u.getConnected(),
				 u.getPassword()));

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
  	public ResponseEntity<String>  deleteUser(@PathVariable("id")int id) {
		userDetailsService.DeleteUser(id);
  	    return new ResponseEntity<String>("Piece deleted successfully",HttpStatus.ACCEPTED);
  		
  	}
	@GetMapping(value = "/user-numbers")
	@Operation(security = {@SecurityRequirement(name = "bearer-key")})
	@ResponseBody
	public long userNumber() {
		return userDetailsService.userCount();
	}
	
	

}