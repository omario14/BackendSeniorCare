package dsi.senior.services;

import java.util.Set;

import dsi.senior.entities.Medication;

public interface IMedicationService {

	public Medication newMedication ( Medication m);
	public Set<Medication> getAllMedication();
	public Set<Medication> getMedicationBySenior(long idSenior);
	public void deleteMedication(long idmed);
}
