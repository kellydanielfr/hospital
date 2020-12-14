package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.*;

public class main {
	private List<Patient> fileAttente = new ArrayList<Patient>();
	private Compte connected;

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
		// TODO Auto-generated method stub

	}
	
	public void menuPrincipal() {
		
	}

}
