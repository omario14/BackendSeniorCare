package dsi.senior.repositories;

import java.util.Set;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import dsi.senior.entities.ArchiveSenior;
import dsi.senior.entities.DoseTime;
import dsi.senior.entities.Medication;


public interface DoseTimeDao extends CrudRepository<DoseTime, Long> {
	
	

	@Query("SELECT DoseTime FROM  DoseTime dt WHERE dt.arch_id_arch:=arch AND dt.med_idmed:=medic ")
	public Set<DoseTime> findDoseTimeByArchAndMed(@Param("arch")ArchiveSenior arch,@Param("medic")Medication medic);

}
