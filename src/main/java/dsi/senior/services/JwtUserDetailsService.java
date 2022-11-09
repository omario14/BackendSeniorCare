package dsi.senior.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dsi.senior.entities.DAOUser;
import dsi.senior.entities.ERole;
import dsi.senior.entities.Role;
import dsi.senior.repositories.RoleDao;
import dsi.senior.repositories.UserDao;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	private static final Logger l = LogManager.getLogger(JwtUserDetailsService.class);
	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleDao roleDao;

	public void initRoleAndUser() {

        Role adminRole = new Role();
        
        adminRole.setName(ERole.ROLE_ADMIN);
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setName(ERole.ROLE_CHEF);
        roleDao.save(userRole);

        DAOUser adminUser = new DAOUser();
        adminUser.setUsername("admin123");
        adminUser.setPassword(getEncodedPassword("admin@pass"));
        adminUser.setEmail("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        userDao.save(adminUser);

//        User user = new User();
//        user.setUserName("raj123");
//        user.setUserPassword(getEncodedPassword("raj@123"));
//        user.setUserFirstName("raj");
//        user.setUserLastName("sharma");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userDao.save(user);
    }

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		} 

		return UserDetailsImpl.build(user);
		
	}
	public DAOUser UpdateAccountUserByUsername(int id,DAOUser user) {
		DAOUser role2 = userDao.findById(id).get();
		
		role2.setName(user.getName());
		role2.setLastName(user.getLastName());
		role2.setMobile(user.getMobile());
		role2.setGender(user.getGender());
		role2.setAdress(user.getAdress());
		role2.setUsername(user.getUsername());
		role2.setPicture(user.getPicture());
		role2.setEmail(user.getEmail());
		role2.setPassword(user.getPassword());
		role2.setRoles(user.getRoles());
		userDao.save(role2);
		return role2;
	}
	
	

	

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
	 private Set getAuthority(DAOUser user) {
	        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	        user.getRoles().forEach(role -> {
	            authorities.add(new SimpleGrantedAuthority("" + role.getName()));
	        });
	        return authorities;
	    }
		public List<DAOUser> retreiveAllUsers() {
			List<DAOUser> listuser = (List<DAOUser>) userDao.findAll() ;
			for(DAOUser piece : listuser) {
				l.info("piece : "+piece);
			}
			return listuser;
		}
		public DAOUser findById(int id) {
			return userDao.findById(id).get();
		}
		public void DeleteUser(int id) {
			userDao.deleteById(id);
			
			
		}
		
		public long userCount() {
			return userDao.userCount();
		}
		
	 
}