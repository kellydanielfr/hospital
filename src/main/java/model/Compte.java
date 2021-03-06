package model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="type_compte")
public abstract class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(unique = true)
	protected String login;
	protected String password;
	
	public Compte() {}

	public Compte(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public static void afficherListAttente(LinkedList<Patient> fileAttente) {
		System.out.println("J'affiche la liste d'attente: ");
		for (Patient patient : fileAttente) {
			System.out.println(patient);
			System.out.println("----------------------------");
		}
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
