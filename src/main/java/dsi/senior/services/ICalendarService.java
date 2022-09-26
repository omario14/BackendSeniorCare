package dsi.senior.services;

import java.util.List;

import dsi.senior.entities.Calendar;
import request.EventRequest;

public interface ICalendarService {
	public List<Calendar> getCalendar();
	public void addToCalendar(EventRequest event);
	public void removeEvent(String idEvent);
	public List<Calendar> findCalendarBySenior(long idSenior);

}
