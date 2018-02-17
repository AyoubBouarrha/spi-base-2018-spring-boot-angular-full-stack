package fr.univbrest.dosi.repositories;

import fr.univbrest.dosi.bean.Candidat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidatRepository extends CrudRepository<Candidat, String> {

    List<Candidat> findByNom(String nom);
    List<Candidat> findByUniversiteOrigine(String universiteOrigine);

}
