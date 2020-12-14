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

public class Patient implements Serializable{
	private String id;
	private String nom, prenom;
	private Adresse adresse;
	

	public static void ecrireObject(List<Patient> fileAttente) 
	{
		
			
		String chemin="fileAttente.txt";
		File monFichier = new File(chemin);
		
		try (
				FileOutputStream fos = new FileOutputStream(monFichier);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
			){
		
			for (Patient p : fileAttente) {
				oos.writeObject(p);
			}
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	public static List<Patient> lireObject() 
	{
		List<Patient> fileAttente = new ArrayList<Patient>();
		String chemin="fileAttente.txt";
		File monFichier = new File(chemin);
		
		try (
				FileInputStream fis = new FileInputStream(monFichier);
				ObjectInputStream ois = new ObjectInputStream(fis);
			){
		
			
			for(Patient p : (List<Patient>)ois.readObject()) 
			{
				System.out.println(p);
				fileAttente.add(p);
			}
			
		
		}
		catch(Exception e ) 
		{
			e.printStackTrace();
		}
		
		return fileAttente;
		
	}
}
