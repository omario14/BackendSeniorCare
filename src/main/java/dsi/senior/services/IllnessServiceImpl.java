package dsi.senior.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dsi.senior.entities.Illnesses;
import dsi.senior.repositories.IllnessDao;

@Service
public class IllnessServiceImpl implements IIllnessService{

	@Autowired
	private IllnessDao illnessDao;
	@Override
	public List<Illnesses> retreiveAllIllnesses() {

		return (List<Illnesses>) illnessDao.findAll() ;
	}

	@Override
	public Illnesses retrieveIllnessById(long id) {
		Illnesses illness = illnessDao.findById(id).get();
		return illness;
	}

	@Override
	public Illnesses findIllnessByLabel(String label) {
		Illnesses illness = illnessDao.findIllnessByLabel(label);
		return illness;
	}

}
