package model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import config.Context;



@Entity
@DiscriminatorValue("Medecin")
public class Medecin extends Compte{
	
	private Salle salle;
	
	@Transient
	private List<Visite> listVisite = new ArrayList<Visite>();
	
	public Medecin() {}

	public Medecin(String login, String password, Salle salle) {
		super(login, password);
		this.salle = salle;
	}
	
	public void rendreSalle(LinkedList<Patient> fileAttente) {
		Patient nextPatient = afficherProchainPatient(fileAttente);
		creerVisite(nextPatient);
	}
	
	public Patient returnProchainPatient(LinkedList<Patient> fileAttente) {
		return fileAttente.poll();
	}
	
	public void creerVisite(Patient patient) {
		ZoneId zid = ZoneId.of("Europe/Paris");
		LocalDate lt = LocalDate.now(zid);
		Visite newVisite = new Visite(patient, this, this.getSalle(), lt);
		
		if (listVisite.size() >= 10) {
			saveList();
		}
		listVisite.add(newVisite);
		
		System.out.println("La visite a été créée");
	}
	
	public void afficherPatient (Patient patient) {
		System.out.println("Voici la description du patient: \n" + patient);
	}
	
	public Patient afficherProchainPatient(LinkedList<Patient> fileAttente) {
		System.out.println("Le prochain patient est : ");
		return fileAttente.peek();
	}
	
	public void saveList() {
		for (Visite visite : listVisite) {
			Context.getInstance().getDaoVisite().insert(visite);
		}
		listVisite = new ArrayList<Visite>();
		
		System.out.println("La liste des visites a été sauvegardée");
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	@Override
	public String toString() {
		return ""+id;
	}


}
