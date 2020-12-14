package test;

import java.nio.channels.AlreadyConnectedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import config.Context;
import model.*;

public class main {
	private static List<Patient> fileAttente = new ArrayList<Patient>();
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
//		Medecin m1 = new Medecin(1, "m1", "pass", Salle.SALLE1);
//		Secretaire s1 = new Secretaire(2, "s1", "pass");
//		connected = s1;
//		connected = m1;
		
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
		case 2: ((Medecin) connected).rendreSalle();break;
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
			patient = ((Secretaire) connected).creerPatient(numPatient);
		}
		
		fileAttente = ((Secretaire) connected).ajouterPatient(patient, fileAttente);
	}

	private static void afficherHistorique() {
		Integer numPatient = saisieInt("Entrez le numero de secu du patient:");
		
		Patient patient = Context.getInstance().getDaoPatient().findById(numPatient);
		
		if (patient == null) {
			System.out.println("Le patient n'existe pas");
			menuSecretaire();
		}else {
			((Secretaire) connected).afficherHistorique(patient);
		}
	}
}
