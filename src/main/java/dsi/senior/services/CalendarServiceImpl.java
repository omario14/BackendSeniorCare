package dsi.senior.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.Calendar;
import dsi.senior.entities.Senior;
import dsi.senior.repositories.CalendarDao;
import dsi.senior.repositories.SeniorDao;
import request.EventRequest;

@Service
public class CalendarServiceImpl  implements ICalendarService{

	@Autowired
	CalendarDao calendarDao;
	@Autowired
	SeniorDao seniorDao;
	
	@Override
	public List<Calendar> getCalendar() {
		return (List<Calendar>) calendarDao.findAll();
	}

	@Override
	public void addToCalendar(EventRequest event) {
		Calendar c = new Calendar();
		if (event.getSenior()==0) {
			c = new Calendar(event.getId(), event.getName(), event.getColor(), event.getType().toLowerCase(), event.getDate());
		}else {
			Senior s = seniorDao.findById(event.getSenior()).get();
			c = new Calendar(event.getId(), event.getName(), event.getColor(), event.getType().toLowerCase(), event.getDate(),s);
		}
		
		calendarDao.save(c);
		
	}

	@Override
	public void removeEvent(String idEvent) {
		calendarDao.deleteById(idEvent);
		
	}

	@Override
	public List<Calendar> findCalendarBySenior(long idSenior) {
		
		if (idSenior == 0) {
			return calendarDao.findCalendarByType("all");
		}else {
			Senior senior = seniorDao.findById(idSenior).get();
			return  calendarDao.findCalendarBySenior(senior);
		}
	}

}
