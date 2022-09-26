package dsi.senior.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.Calendar;
import dsi.senior.entities.Senior;

@Repository
public interface CalendarDao extends CrudRepository<Calendar, String>{

	
	@Query("SELECT calendar FROM  Calendar c WHERE c.senior_id:=idSenior ")
	public List<Calendar> findCalendarBySenior(@Param("idSenior")Senior idSenior);
	
	
	@Query("SELECT calendar FROM  Calendar c WHERE c.type:=idSenior ")
	public List<Calendar> findCalendarByType(@Param("idSenior")String idSenior);
	
}
