package dao;

import com.sun.istack.Nullable;

import model.Compte;

public interface IDAOCompte extends IDAO<Compte,Integer>{
	
	
	@Nullable
	public Compte SelectByLoginMdp(String login, String pwd);

}
