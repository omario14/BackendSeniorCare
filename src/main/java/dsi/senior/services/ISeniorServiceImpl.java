package dsi.senior.services;

import java.util.List;
import java.util.Map;

import dsi.senior.entities.Senior;

public interface ISeniorServiceImpl   {
	public Senior  addSenior(Senior s);
	public void deleteSenior(long id);
	public void updateSenior(Senior s,long idSenior);
	public List<Senior> retrieveAllSenior();
	public void  addMenuSenior(long idSenior);
	public Senior retrieveSeniorById (long id);
	public double calculBMI (double weight,double height);
	public Senior findSeniorByName(String name);	
	public List<Senior> findByResidance(String lieu_resid);
	public Boolean existByid(Long id);
	public void deleteAllSenior() ;
	public Map<String, Long> centreDinteret();
	public Map<Integer, Long> bmiEnFncDage();
		
}
