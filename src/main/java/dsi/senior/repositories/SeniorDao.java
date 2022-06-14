package dsi.senior.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.Senior;

@Repository
public interface SeniorDao extends CrudRepository<Senior,Long> {
	/**********************************Find senior ByName***************************/
	@Query("SELECT sa from Senior sa WHERE sa.name =:name")
	public Senior findSeniorByName(@Param("name")String name);
	
	/**********************************Find senior ByResidance***************************/
	@Query("SELECT sa from Senior sa WHERE sa.residance =:resid")
	public List<Senior> findSeniorsByResidance(@Param("resid")String resid);

	
	
}
