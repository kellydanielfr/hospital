package model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Secretaire")
public class Secretaire extends Compte{
	
	
	public Secretaire() {
	}

	public Secretaire(Integer id, String login, String password) {
		super(id, login, password);
		
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

	@Override
	public String toString() {
		return "Secretaire [id=" + id + ", login=" + login + ", password=" + password + "]";
	}




	
}
