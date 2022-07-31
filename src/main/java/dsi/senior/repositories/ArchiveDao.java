package dsi.senior.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.ArchiveSenior;
import dsi.senior.entities.Senior;

@Repository
public interface ArchiveDao extends CrudRepository<ArchiveSenior, String> {

	@Query("SELECT archivesenior FROM  archivesenior arch WHERE arch.date:=tdDate ")
	public List<ArchiveSenior> findArchiveByDate(@Param("tdDate")String tdDate);
	
	@Query("SELECT archivesenior FROM  archivesenior arch WHERE arch.senior_id:=idSenior ")
	public Set<ArchiveSenior> findArchivesBySenior(@Param("idSenior")Senior idSenior);
	

}
