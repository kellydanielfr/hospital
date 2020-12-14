package model;

import java.time.LocalDate;

public class Visite {
	private Integer numero;
	private Patient id_patient;
	private Medecin id_medecin;
	private Integer cout =20;
	private Salle salle;
	private LocalDate date;
	
	
	public Visite() {}

	public Visite(Integer numero, Patient id_patient, Medecin id_medecin, Integer cout, Salle salle, LocalDate date) {
		this.numero = numero;
		this.id_patient = id_patient;
		this.id_medecin = id_medecin;
		this.cout = cout;
		this.salle = salle;
		this.date = date;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Patient getId_patient() {
		return id_patient;
	}

	public void setId_patient(Patient id_patient) {
		this.id_patient = id_patient;
	}

	public Medecin getId_medecin() {
		return id_medecin;
	}

	public void setId_medecin(Medecin id_medecin) {
		this.id_medecin = id_medecin;
	}

	public Integer getCout() {
		return cout;
	}

	public void setCout(Integer cout) {
		this.cout = cout;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Visite [numero=" + numero + ", id_patient=" + id_patient + ", id_medecin=" + id_medecin + ", cout="
				+ cout + ", salle=" + salle + ", date=" + date + "]";
	}
}
