package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Visite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	
	@OneToOne
	private Patient patient;
	
	@OneToOne
	private Medecin medecin;
	private Integer count =20;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="visite")
	private Salle salle;
	
	@Column(columnDefinition = "DATE")
	private LocalDate date;
	
	
	public Visite() {}

	public Visite(Patient patient, Medecin medecin, Salle salle, LocalDate date) {
		this.patient = patient;
		this.medecin = medecin;
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
		return patient;
	}

	public void setId_patient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getId_medecin() {
		return medecin;
	}

	public void setId_medecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Integer getCout() {
		return count;
	}

	public void setCout(Integer cout) {
		this.count = cout;
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
		return "Medecin: " + medecin + 
				", cout: " + count + 
				", salle: " + salle + 
				", date :" + date +
				", Patient " + patient.getId();
	}
}
