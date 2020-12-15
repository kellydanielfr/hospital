package dao;

import java.util.List;

import model.Visite;

public interface IDAOVisite extends IDAO<Visite,Integer>{

	List<Visite> findByPatient(Integer num_patient);

}
