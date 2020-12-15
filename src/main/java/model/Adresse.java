package model;

import java.io.Serializable;

import javax.persistence.*;


@Embeddable

public class Adresse implements Serializable{
	private Integer numero;
	private String voie, ville, cp;
	
	
	public Adresse() {}

	public Adresse(Integer numero, String voie, String ville, String cp) {
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp = cp;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "numero: " + numero + 
				"\n voie: " + voie + 
				"\n ville: " + ville + 
				"\n cp: " + cp;
	}
}
