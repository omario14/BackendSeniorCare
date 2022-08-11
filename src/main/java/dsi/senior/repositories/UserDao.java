package dsi.senior.repositories;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.DAOUser;
import dsi.senior.entities.Role;




@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	Role findRoleByUsername(String username);
	
	@Query("SELECT count(usr) FROM DAOUser usr")
	public long userCount(); 
	
}