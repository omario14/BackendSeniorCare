package dsi.senior.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.BodyParts;
import dsi.senior.entities.Symptoms;

@Repository
public interface SymptomsDao extends CrudRepository<Symptoms, Long> {
	
	/**********************************Find symptom ByLabel***************************/
	@Query("SELECT symp from Symptoms symp WHERE symp.label =:label")
	public Symptoms findSymptomByLabel(@Param("label")String label);
	
	/**********************************Find symptom bodyParts***************************/
	@Query("SELECT symp from Symptoms symp WHERE symp.body_id =:bodyPart")
	public List<Symptoms> findSymptomByBodyParts(@Param("bodyPart")BodyParts bodyPart);

}
