package dsi.senior.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.Senior;
import dsi.senior.repositories.SeniorDao;

@Service
public class SeniorServiceImpl implements ISeniorServiceImpl{
	
	@Autowired
	SeniorDao seniorDao;
	
	/********************** ADD method that insert Senior into database***************/
	@Override
	public long addSenior(Senior s) {
		Senior senior =new Senior(
					s.getName(),
					s.getLastname(),
					s.getDateOfBirth(),
					s.getSex(),
					s.getCin(),
					s.getTelephone(),
					s.getResidance(),
					s.getFamillySituation(),
					s.getCenterOfInterest(),
					s.getFile());
		seniorDao.save(senior);
		return senior.getId();
	}
	/********************** DELETE method that delete Senior from database***************/
	@Override
	public void deleteSenior(long id) {
		seniorDao.deleteById(id);
		
	}
	
	

	/********************** UPDATE method that updates Senior***************/
	@Override
	public void updateSenior(Senior s, long idSenior) {
		Senior sa = seniorDao.findById(idSenior).get();
		sa.setName(s.getName());
		sa.setLastname(s.getLastname());
		sa.setDateOfBirth(s.getDateOfBirth());
		sa.setResidance(s.getResidance());
		sa.setSex(s.getSex());
		sa.setCin(s.getCin());
		sa.setCenterOfInterest(s.getCenterOfInterest());
		sa.setFamillySituation(s.getFamillySituation());
		sa.setTelephone(s.getTelephone());
		seniorDao.save(sa);
		
	}

	/********************** FIND method that retrieve All Seniors***************/
	@Override
	public List<Senior> retrieveAllSenior() {
		
		return (List<Senior>) seniorDao.findAll();
	}
	

	/********************** FINDBYID method that find Senior by id***************/
	@Override
	public Senior retrieveSeniorById(long id) {
		Senior sa = seniorDao.findById(id).get();
		return sa;
	}

	/********************** FINDBYNAME method that find Senior by NAME***************/
	@Override
	public Senior findSeniorByName(String name) {
		Senior sa = seniorDao.findSeniorByName(name);
		return sa;
	}
	/********************** FINDBYRESIDANCE method that find Senior by RESIDANCE***************/
	@Override
	public List<Senior> findByResidance(String place_resid) {
		List<Senior> seniors = seniorDao.findSeniorsByResidance(place_resid);
		return seniors;
	}
	@Override
	public Boolean existByid(Long id){
		return seniorDao.existsById(id);
	}
	
	
	/********************** DELETE method that delete All Senior from database***************/
	@Override
	public void deleteAllSenior() {
		seniorDao.deleteAll();
		
	}

}
