package dsi.senior.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
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
	@Query("SELECT sa from Senior sa WHERE sa.adress =:resid")
	public List<Senior> findSeniorsByResidance(@Param("resid")String resid);

	@Query("SELECT centerOfInterest FROM Senior")
	public List<String> centreDinteretseniors(); 
	
	@Query("SELECT dateOfBirth FROM Senior")
	public List<String> birthDateSeniors(); 
	
	@Query("SELECT count(snr) FROM Senior snr")
	public long seniors(); 
	
	
}
