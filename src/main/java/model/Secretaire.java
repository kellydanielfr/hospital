package model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import config.Context;

@Entity
@DiscriminatorValue("Secretaire")
public class Secretaire extends Compte{
	
	
	public Secretaire() {
	}

	public Secretaire(String login, String password) {
		super(login, password);
	}
	
	public Patient creerPatient(Integer numPatient, String nom, String prenom, Integer numero, String voie, String ville, String cp) {
		Adresse adresse = new Adresse(numero, voie, ville, cp);
		Patient patient = new Patient(numPatient, nom, prenom, adresse);
		Context.getInstance().getDaoPatient().insert(patient);
		return patient;
	}
	
	public LinkedList<Patient> ajouterPatient(Patient patient, LinkedList<Patient> fileAttente){
		fileAttente.add(patient);
		return fileAttente;
	}
	
	public void afficherHistorique(Patient patient) {
		System.out.println("Voisci l'historique du patient: ");
		List<Visite> historique = Context.getInstance().getDaoVisite().findByPatient(patient.getId());
		for (Visite visite : historique) {
			System.out.println(visite);
		}
	}
	
	public void partirEnPause(LinkedList<Patient> fileAttente) {
		Patient.ecrireObject(fileAttente);
		System.out.println("La secrétairte part en pause");
	}
	
	public LinkedList<Patient> revenirDePause() {
		LinkedList<Patient> fileAttente = Patient.lireObject();
		System.out.println("La secrétaite revient de pause");
		return fileAttente;
	}
	
	public boolean verifPatient(Integer numPatient) {
		Patient patient = Context.getInstance().getDaoPatient().findById(numPatient);
		
		if (patient == null) {
			System.out.println("Le patient n'existe pas");
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Secretaire [id=" + id + ", login=" + login + ", password=" + password + "]";
	}




	
}
