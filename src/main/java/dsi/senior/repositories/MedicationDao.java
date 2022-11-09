package dsi.senior.repositories;

import java.util.Set;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dsi.senior.entities.Medication;
import dsi.senior.entities.Senior;

@Repository
public interface MedicationDao  extends CrudRepository<Medication, Long>{
	

	@Query("SELECT medication FROM  medication med WHERE med.senior_id:=idSenior ")
	public Set<Medication> findMedicationBySenior(@Param("idSenior")Senior idSenior);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM medication med  WHERE med.senior_id:=idSenior")
	  void deleteMedicationBySenior(@Param("idSenior")Senior idSenior);

}
