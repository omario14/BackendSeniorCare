package dsi.senior.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dsi.senior.entities.FileDB;

@Repository
public interface FileDBDao extends CrudRepository<FileDB, String>{

}
