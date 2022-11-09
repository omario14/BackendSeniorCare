package dsi.senior.repositories;


import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import dsi.senior.entities.ArchiveMedication;
import dsi.senior.entities.ArchiveSenior;
import dsi.senior.entities.Medication;

@Repository
public interface ArchiveMedsDao extends CrudRepository<ArchiveMedication, Long>{
	
	@Query("SELECT archm FROM ArchiveMedication archm WHERE archm.archive=:idArch")
	 Set<ArchiveMedication> getarchMedsByIdArch(@Param("idArch") ArchiveSenior idArch);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM ArchiveMedication a  WHERE a.meds=:idMed")
	  void deleteNombreEmployeJPQL(@Param("idMed")Medication idMed);


	@Transactional
	@Modifying
	@Query("DELETE FROM ArchiveMedication a  WHERE a.meds=:idMed AND a.archive=:idArch")
	  void deleteArchiveMedicationBymeds(@Param("idMed")Medication idMed,@Param("idArch")ArchiveSenior idArch);


	
	@Transactional
	@Modifying
	@Query("DELETE FROM ArchiveMedication a  WHERE a.archive=:idArch")
	  void deleteArchiveMedicationByArchive(@Param("idArch")ArchiveSenior idArch);

}
