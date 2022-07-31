package dsi.senior.services;

import java.util.List;
import java.util.Set;

import dsi.senior.entities.ArchiveSenior;

public interface IArchiveSeniorService {
	/**********************Creating add method that insert Archive into database***************/
	void addArchive(ArchiveSenior arch);

	/****************Creating update method that upgrade archive from database*****************/
	void updateArchive(ArchiveSenior arch, String idArch);

	/*******************Creating deleting method that remove archive by id  from database
	 * @return *********/
	long deleteArchive(long idArch);
	
	/***************Creating getAll method that retrieve all ArchiveSenior from database **************/
	List<ArchiveSenior> getAllArchives();

	/**************Creating getByid method that retrieve ArchiveSenior detail from database************/
	Set<ArchiveSenior> getArchiveSeniorBySenior(long idSenior);

	/***************Creating getAll ArchiveSenior by category method from database **************/
	List<ArchiveSenior> getArchiveSeniorByCategory(String categoryName); 

}
