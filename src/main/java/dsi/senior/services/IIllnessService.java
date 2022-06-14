package dsi.senior.services;

import java.util.List;

import dsi.senior.entities.Illnesses;


public interface IIllnessService {
	
	public List<Illnesses> retreiveAllIllnesses ();
	public Illnesses retrieveIllnessById (long id);
	public Illnesses findIllnessByLabel(String label);	


}
