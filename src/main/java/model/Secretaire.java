package model;

import java.util.List;

public class Secretaire extends Compte{
	private String typeCompte = "Secretaire";

	
	public Secretaire() {
	}

	public Secretaire(Integer id, String login, String password, String typeCompte) {
		super(id, login, password);
		this.typeCompte = typeCompte;
	}
	
	public List<Patient> ajouterPatient(Patient patient){
		return null;
	}
	
	public void afficherHistorique(Patient patient) {
		
	}
	
	public void partirEnPause(List<Patient> fileAtttente) {
		
	}
	
	public List<Patient> revenirDePause() {
		return null;
	}
	
	public boolean verifPatient(Patient patient) {
		return true;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	@Override
	public String toString() {
		return "Secretaire [typeCompte=" + typeCompte + ", id=" + id + ", login=" + login + ", password=" + password
				+ "]";
	}
}
