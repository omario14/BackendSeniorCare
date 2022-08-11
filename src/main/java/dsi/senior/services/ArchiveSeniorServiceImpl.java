package dsi.senior.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.ArchiveSenior;
import dsi.senior.entities.Senior;
import dsi.senior.repositories.ArchiveDao;
import dsi.senior.repositories.SeniorDao;

@Service
public class ArchiveSeniorServiceImpl implements IArchiveSeniorService {

	
	@Autowired
	ArchiveDao archDao;
	@Autowired
	SeniorDao seniorDao;
	
	@Override
	public void addArchive(ArchiveSenior arch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArchive(ArchiveSenior arch) {
		
	 	    archDao.save(arch);
	   
	   
	    
	    
	    
		
	}

	@Override
	public long deleteArchive(long idArch) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ArchiveSenior> getAllArchives() {
		return  (List<ArchiveSenior>) archDao.findAll();
	}

	@Override
	public Set<ArchiveSenior> getArchiveSeniorBySenior(long idSenior) {
		Senior s = seniorDao.findById(idSenior).get();
		return archDao.findArchivesBySenior(s);
		 
	}

	@Override
	public List<ArchiveSenior> getArchiveSeniorByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
