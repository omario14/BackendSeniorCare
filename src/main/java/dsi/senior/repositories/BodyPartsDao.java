package dsi.senior.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.BodyParts;

@Repository
public interface BodyPartsDao extends CrudRepository<BodyParts, Long>{

}
