package dao;

import java.util.List;

import model.Compte;

public interface IDAO <T,K> {
	
	String lien="jdbc:mysql://localhost:3306/";
	String database="hopital";
	String login="root";
	String password="";
	
	 public T findById(K id);
	 public List<T> findAll();
	 public void insert(T objet);
	 public T update(T object);
	 public void delete(T id);
	
	
	 
	 

}
