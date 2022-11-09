package dsi.senior.repositories;

import java.util.Set;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import dsi.senior.entities.ArchiveSenior;
import dsi.senior.entities.DoseTime;
import dsi.senior.entities.Medication;


public interface DoseTimeDao extends CrudRepository<DoseTime, Long> {
	
	

	@Query("SELECT DoseTime FROM  DoseTime dt WHERE dt.arch_id_arch:=arch AND dt.med_idmed:=medic ")
	public Set<DoseTime> findDoseTimeByArchAndMed(@Param("arch")ArchiveSenior arch,@Param("medic")Medication medic);

	@Transactional
	@Modifying
	@Query("DELETE FROM DoseTime a  WHERE a.arch_id_arch:=arch")
	  void deleteDoseTimeByArch(@Param("arch")ArchiveSenior arch);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM DoseTime dt  WHERE dt.med_idmed:=medic")
	  void deleteDoseTimeByMed(@Param("medic")Medication medic);

}
