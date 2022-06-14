package dsi.senior.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import dsi.senior.entities.ERole;
import dsi.senior.entities.Role;


public interface RoleDao extends CrudRepository<Role, Integer>{
	Optional<Role> findByName(ERole name);
	
}
