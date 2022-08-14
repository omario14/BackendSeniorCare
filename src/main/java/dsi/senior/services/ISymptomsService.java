package dsi.senior.services;

import java.util.List;

import dsi.senior.entities.BodyParts;
import dsi.senior.entities.Symptoms;


public interface ISymptomsService {
	
	public List<Symptoms> retreiveAllSymtoms ();
	public Symptoms retrieveSymptomById (long id);
	public Symptoms findSymptomByLabel(String label);	
	public BodyParts findBodyPartById (long body_id);
	public Symptoms updateSymptoms(long symp);
	public List<Symptoms> findSymptomsByPartId (long body_id);

}
