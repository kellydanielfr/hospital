package model;

import java.util.List;

public abstract class Compte {
	protected Integer id;
	protected String login;
	protected String password;
	
	public Compte() {}

	public Compte(Integer id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}
	
	public static void afficherListAttente(List<Patient> fileAttente) {
		System.out.println("J'affiche la liste d'attente");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
	
	
}
