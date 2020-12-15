package dao;

import java.util.List;

import model.Visite;

public interface IDAOVisite extends IDAO<Visite,Integer>{

	List<Visite> findByPatient(Integer num_patient);

	List<Visite> findByMedecin(Integer id_medecin);

}
