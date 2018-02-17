package fr.univbrest.dosi.repositories;

import fr.univbrest.dosi.bean.Enseignant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnseignantRepository extends CrudRepository<Enseignant, Long> {
    List<Enseignant> findFirstByNom(String nom);
    List<Enseignant> findFirstByEmailUbo(String emailUBO);
    List<Enseignant> findByVille(String ville);
}
