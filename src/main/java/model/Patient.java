package model;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nom, prenom;
	
	
	@Embedded
	private Adresse adresse;
	
	
	
	public Patient() {}
	

	public Patient(Integer id, String nom, String prenom, Adresse adresse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}


	public static void ecrireObject(List<Patient> fileAttente) {	
		String chemin="fileAttente.txt";
		File fileDattente = new File(chemin);
		
		try (	FileOutputStream fos = new FileOutputStream(fileDattente);
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
		
			for (Patient p : fileAttente) {
				oos.writeObject(p);
			}
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	public static List<Patient> lireObject(){
		List<Patient> fileAttente = new ArrayList<Patient>();
		String chemin="fileAttente.txt";
		File fileDattente = new File(chemin);
		
		try (	FileInputStream fis = new FileInputStream(fileDattente);
				ObjectInputStream ois = new ObjectInputStream(fis);){
		
			for(Patient p : (List<Patient>)ois.readObject()){
				System.out.println(p);
				fileAttente.add(p);
			}
		}catch(Exception e ){
			e.printStackTrace();
		}
		return fileAttente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + "]";
	}
}
