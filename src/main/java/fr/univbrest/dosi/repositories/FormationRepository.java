package fr.univbrest.dosi.repositories;

import fr.univbrest.dosi.bean.Formation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FormationRepository extends CrudRepository<Formation, String> {
    List<Formation> findByNomFormation(String nomFormation);
}
