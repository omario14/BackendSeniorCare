package dsi.senior.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.ERole;
import dsi.senior.entities.Notification;
import dsi.senior.repositories.NotificationDao;
import dsi.senior.repositories.UserDao;

@Service
public class NotificationServiceImpl implements INotificationService {

	@Autowired
	NotificationDao notificationDao;
	@Autowired
	UserDao userDao;
	@Autowired
	JwtUserDetailsService userService;
	
	@Override
	public void addNotification(Notification notif) {
		userDao.findAll().forEach(u->{
			Notification n = new Notification(notif.getSenderName(),notif.getMessage(),notif.getDate(),notif.getType()); 
			u.getRoles().forEach(r->{
				if(r.getName()==ERole.ROLE_ACCOMPAGNANT) {
					
					n.setReceiverName(u.getUsername());
					
				}
			});
			notificationDao.save(n);
		});
		
		
	}

	@Override
	public Set<Notification> getNotifications() {
		
		return (Set<Notification>) notificationDao.findAll();
	}

	@Override
	public Set<Notification> getNotifByUser(String user) {
		
		return notificationDao.findNotificationByReceiverName(user);
	}
	
	@Override
	public void deleteNotification(long id) {
		
		 notificationDao.deleteById(id);
	}

}
