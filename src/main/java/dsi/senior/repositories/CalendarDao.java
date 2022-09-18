package dsi.senior.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.Calendar;

@Repository
public interface CalendarDao extends CrudRepository<Calendar, String>{

}
