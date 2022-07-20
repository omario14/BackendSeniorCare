package dsi.senior.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.Menu;

@Repository
public interface MenuDao extends CrudRepository<Menu, Long> {

}
