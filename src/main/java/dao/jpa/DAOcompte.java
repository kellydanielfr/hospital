package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOCompte;
import model.Compte;

public class DAOcompte implements IDAOCompte{

	@Override
	public Compte findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Compte c = em.find(Compte.class, id);
		em.close();
		return c;
	}

	@Override
	public List<Compte> findAll() {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("from Compte",Compte.class);

		return maRequete.getResultList();
	}

	@Override
	public void insert(Compte objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Compte update(Compte objet) {
		 
			EntityManager em=Context.getInstance().getEmf().createEntityManager();
			em.getTransaction().begin();
			objet=em.merge(objet);
			em.getTransaction().commit();
			em.close();
			return objet;
		
	}

	@Override
	public void delete(Compte id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		id=em.merge(id);

		em.remove(id);

		em.getTransaction().commit();
		em.close();
		
	}


	@Override
	public Compte SelectByLoginMdp(String login, String pwd) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		
		Query maRequete = em.createQuery("from Compte c where c.login=:loginReq and c.password=:password ",Compte.class);
		maRequete.setParameter("loginReq",login);
		maRequete.setParameter("password",pwd);
		Compte c = (Compte) maRequete.getSingleResult();
		em.close();
		return c;
	}



}
