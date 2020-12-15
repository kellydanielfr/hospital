package test;

import java.nio.channels.AlreadyConnectedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import config.Context;
import model.*;

public class main {
	private static LinkedList<Patient> fileAttente = new LinkedList<Patient>();
	private static Compte connected = null;

	public static int saisieInt(String msg) 
	{
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public static double saisieDouble(String msg) 
	{
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}


	public static String saisieString(String msg) 
	{
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static void main(String[] args) {
		
		//Tests
//		Medecin m1 = new Medecin("m1", "pass", Salle.SALLE1);
//		Medecin m2 = new Medecin("m2", "pass", Salle.SALLE2);
//		Secretaire s1 = new Secretaire("s1", "pass");
//		
//		Context.getInstance().getDaoCompte().insert(s1);
//		Context.getInstance().getDaoCompte().insert(m1);
//		Context.getInstance().getDaoCompte().insert(m2);

		Adresse a1 = new Adresse(1, "voie", "ville", "cp");
		Patient p1 = new Patient(123, "nom", "prenom", a1);
		fileAttente.add(p1);
		Adresse a2 = new Adresse(2, "voie", "ville", "cp");
		Patient p2 = new Patient(124, "nom", "prenom", a1);
		fileAttente.add(p2);
		
		
		//Patient.lireObjecttest();
		menuPrincipal();
	}
	
	public static void menuPrincipal() {
		System.out.println(" ___________________________________");
		System.out.println("|                                   |");
		System.out.println("| Bonjour et bienvenue à l'hospital |");
		System.out.println("|___________________________________|\n");
		
		
		String login = saisieString("Saisir votre login:");
		String password = saisieString("Saisir votre pasword:");
		
		connected = Context.getInstance().getDaoCompte().SelectByLoginMdp(login, password);
		
		if (connected==null) {
			System.out.println("Mauvais identifiants");
			menuPrincipal();
		}else if (connected instanceof Secretaire) {
			menuSecretaire();
		}else {
			menuMedecin();
		}
	}

	private static void menuMedecin() {
		System.out.println("Bienvenue sur votre compte Medecin");
		System.out.println("----------------------------------");
		System.out.println("Que voulez-vous faire ?");
		System.out.println("1-Afficher la liste d'attente");
		System.out.println("2-Rendre la salle");
		System.out.println("3-Afficher le prochain patient");
		System.out.println("4-Sauvegarder la liste des visites");
		System.out.println("5-Deconnexion");
		
		int choix = saisieInt("");
		
		switch (choix) {
		case 1: Compte.afficherListAttente(fileAttente);break;
		case 2: ((Medecin) connected).rendreSalle(fileAttente);break;
		case 3: System.out.println(((Medecin) connected).afficherProchainPatient(fileAttente));break;
		case 4: ((Medecin) connected).saveList();break;
		case 5: connected = null; menuPrincipal();break;
		default: menuMedecin();break;
		}
		
		menuMedecin();
	}

	private static void menuSecretaire() {
		System.out.println("Bienvenue sur votre compte Secretaire");
		System.out.println("-------------------------------------");
		System.out.println("Que voulez-vous faire ?");
		System.out.println("1-Afficher la liste d'attente");
		System.out.println("2-Retourner l'historique d'un patient");
		System.out.println("3-Ajouter un patient à la liste d'attente");
		System.out.println("4-Partir en pause");
		System.out.println("5-Deconnexion");
		
		int choix = saisieInt("");
		
		switch (choix) {
		case 1: Compte.afficherListAttente(fileAttente);break;
		case 2: afficherHistorique();break;
		case 3: ajouterPatient();break;
		case 4: partirEnPause();break;
		case 5: connected = null; menuPrincipal();break;
		default: menuSecretaire();break;
		}
		
		menuSecretaire();
	}

	private static void partirEnPause() {
		((Secretaire) connected).partirEnPause(fileAttente);
		fileAttente = null;
		
		System.out.println("__________________________________");
		System.out.println("|                                 |");
		System.out.println("|La secrétaire est partie en pause|");
		System.out.println("|        Merci de patienter       |");
		System.out.println("|_________________________________|\n");
		
		String revenir = saisieString("Appuyez sur \"Entrée\" pour revenir de pause");
		
		fileAttente = ((Secretaire) connected).revenirDePause();
	}

	private static void ajouterPatient() {
		Integer numPatient = saisieInt("Entrez le numero de secu du patient:");
		
		Patient patient = null;
		
		if (((Secretaire) connected).verifPatient(numPatient)) {
			patient = Context.getInstance().getDaoPatient().findById(numPatient);
		}else {
			System.out.println("Il faut le créer: ");
			String nom = saisieString("Nom du patient:");
			String prenom = saisieString("Prenom du patient:");
			Integer numero = saisieInt("Numero de la voie:");
			String voie = saisieString("Nom de la voie: ");
			String ville = saisieString("Nom de la ville: ");
			String cp = saisieString("Code postal : ");
			
			patient = ((Secretaire) connected).creerPatient(numPatient, nom, prenom, numero, voie, ville, cp);
		}
		
		fileAttente = ((Secretaire) connected).ajouterPatient(patient, fileAttente);
	}

	private static void afficherHistorique() {
		Integer numPatient = saisieInt("Entrez le numero de secu du patient:");
		
		if (((Secretaire) connected).verifPatient(numPatient)) {
			Patient patient = Context.getInstance().getDaoPatient().findById(numPatient);
			((Secretaire) connected).afficherHistorique(patient);
		}else {
			menuSecretaire();
		}
	}
}
