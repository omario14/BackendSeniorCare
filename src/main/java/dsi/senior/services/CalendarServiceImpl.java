package dsi.senior.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.Calendar;
import dsi.senior.repositories.CalendarDao;

@Service
public class CalendarServiceImpl  implements ICalendarService{

	@Autowired
	CalendarDao calendarDao;
	@Override
	public List<Calendar> getCalendar() {
		return (List<Calendar>) calendarDao.findAll();
	}

	@Override
	public void addToCalendar(Calendar c) {
		calendarDao.save(c);
		
	}

}
