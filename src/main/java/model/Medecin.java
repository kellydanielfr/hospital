package model;

import java.util.List;

public class Medecin extends Compte{
	private String typeCompte = "Medecin";
	private Salle salle;
	private List<Visite> listVisite;
	
	public Medecin() {
	}

	public Medecin(Integer id, String login, String password, String typeCompte, Salle salle) {
		super(id, login, password);
		this.typeCompte = typeCompte;
		this.salle = salle;
	}
	
	public void creerVisite(Patient patient) {
		
	}
	
	public void afficherPatient (Patient patient) {
		
	}
	
	public void rendreSalle() {
		
	}
	
	public Patient afficherProchainPatient(List<Patient> listAttente) {
		Patient patient = null;
		return patient;
	}
	
	public void saveList(List<Visite> fileAlistVisite) {
		
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	@Override
	public String toString() {
		return "Medecin [typeCompte=" + typeCompte + ", salle=" + salle + ", listVisite=" + listVisite + ", id=" + id
				+ ", login=" + login + ", password=" + password + "]";
	}


}
