package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOCompte;
import dao.IDAOPatient;
import dao.IDAOVisite;
import dao.jpa.DAOcompte;
import dao.jpa.DAOpatient;
import dao.jpa.DAOvisite;

public class Context {

	
	private static Context _instance=null;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital");
	private IDAOCompte daoCompte= new DAOcompte();
	private IDAOPatient daoPatient = new DAOpatient();
	private IDAOVisite daoVisite = new DAOvisite();
	
	private  Context() {}
	
	public static Context getInstance() 
	{
		if(_instance==null) {_instance=new Context();}
		return _instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	public void closeEmf() 
	{
		emf.close();
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}

	public IDAOPatient getDaoPatient() {
		return daoPatient;
	}

	public void setDaoPatient(IDAOPatient daoPatient) {
		this.daoPatient = daoPatient;
	}

	public IDAOVisite getDaoVisite() {
		return daoVisite;
	}

	public void setDaoVisite(IDAOVisite daoVisite) {
		this.daoVisite = daoVisite;
	}
	 
	
}
