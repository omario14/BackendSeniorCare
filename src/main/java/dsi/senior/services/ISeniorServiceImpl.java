package dsi.senior.services;

import java.util.List;

import dsi.senior.entities.Senior;

public interface ISeniorServiceImpl   {
	public long  addSenior(Senior s);
	public void deleteSenior(long id);
	public void updateSenior(Senior s,long idSenior);
	public List<Senior> retrieveAllSenior();
	public Senior retrieveSeniorById (long id);
	public Senior findSeniorByName(String name);	
	//public Senior affecterRayProduct(int idp, int idr,int qut);
	public List<Senior> findByResidance(String lieu_resid);

}
