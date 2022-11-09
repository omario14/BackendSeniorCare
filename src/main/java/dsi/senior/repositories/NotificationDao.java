package dsi.senior.repositories;

import java.util.Set;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.Notification;

@Repository
public interface NotificationDao extends CrudRepository<Notification, Long> {
	
	@Query("SELECT Notification FROM  Notification n WHERE n.receiverName:=user")
	public Set<Notification> findNotificationByReceiverName(@Param("user")String user);

}
