package dsi.senior.services;

import java.util.Set;

import dsi.senior.entities.Notification;

public interface INotificationService {
	
	public void addNotification(Notification notif);
	public Set<Notification> getNotifications();
	public Set<Notification> getNotifByUser(String user );
	public void deleteNotification(long id);

}
