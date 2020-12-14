package model;

import java.util.List;

import config.Context;

public class Secretaire extends Compte{
	private String typeCompte = "Secretaire";

	
	public Secretaire() {
	}

	public Secretaire(Integer id, String login, String password) {
		super(id, login, password);
	}
	
	public Patient creerPatient(Integer numPatient) {
		System.out.println("Je creer un patient");
		return null;
	}
	
	public List<Patient> ajouterPatient(Patient patient, List<Patient> listAttente){
		System.out.println("J'ajoute un patient");
		return null;
	}
	
	public void afficherHistorique(Patient patient) {
		System.err.println("J'affiche l'historique du patient");
	}
	
	public void partirEnPause(List<Patient> fileAtttente) {
		System.out.println("La secrétairte part en pause");
	}
	
	public List<Patient> revenirDePause() {
		System.out.println("La secrétaite revient de pause");
		return null;
	}
	
	public boolean verifPatient(Integer numPatient) {
		System.out.println("Verif patient");
//		Patient patient = Context.getInstance().getDaoPatient().findById(numPatient);
//		
//		if (patient == null) {
//			System.out.println("Le patient n'existe pas, il faut le créer");
//			return false;
//		}
		
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
