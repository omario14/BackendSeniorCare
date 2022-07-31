package dsi.senior.repositories;



import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.Menu;

@Repository
public interface MenuDao extends CrudRepository<Menu, Long> {
	
	@Query("SELECT menu FROM  Menu m WHERE m.date:=tdDate")
	public Menu findMenuByDate(@Param("tdDate")String tdDate);

	
}