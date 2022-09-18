package dsi.senior.services;

import java.util.List;

import dsi.senior.entities.Calendar;

public interface ICalendarService {
	public List<Calendar> getCalendar();
	public void addToCalendar(Calendar c);

}
