package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOVisite;
import model.Visite;

public class DAOvisite implements IDAOVisite{

	@Override
	public Visite findById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Visite v = em.find(Visite.class, id);
		em.close();
		return v;
	}

	@Override
	public List<Visite> findAll() {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("from Visite",Visite.class);

		return maRequete.getResultList();
	}

	@Override
	public void insert(Visite objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public Visite update(Visite objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);
		em.getTransaction().commit();
		em.close();
		return objet;
	}

	@Override
	public void delete(Visite objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);

		em.remove(objet);

		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public List<Visite> findByPatient(Integer num_patient) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		Query maRequete = em.createQuery("from Visite where patient_id=:num_patient",Visite.class);
		maRequete.setParameter("num_patient",num_patient);
		return maRequete.getResultList();
	}
	
}
