package fr.univbrest.dosi.business;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EnseignantBusinessJPA implements EnseignantBusiness {

    private EnseignantRepository repository;

    @Autowired
    public EnseignantBusinessJPA(EnseignantRepository enseignantRepository) {
        this.repository = enseignantRepository;
    }

    @Override
    public Enseignant creerEnseignant(Enseignant enseignant) {
        return repository.save(enseignant);
    }

    @Override
    public void modifierEnseignant(Enseignant enseignant) {
        repository.save(enseignant);
    }

    @Override
    public void supprimerEnseignant(long noEnseignant) {
        repository.delete(noEnseignant);
    }

    @Override
    public List<Enseignant> recupererEnseignants() {
        return (List<Enseignant>) repository.findAll();
    }

    @Override
    public Enseignant recupererEnseignantParNum(long noEnseignant) {
        return repository.findOne(noEnseignant);
    }

    @Override
    public Enseignant recupererEnseignantParNom(String nom) {
        return repository.findFirstByNom(nom).get(0);
    }

    @Override
    public Enseignant recupererEnseignantParEmailUBO(String emailUBO) {
        return repository.findFirstByEmailUbo(emailUBO).get(0);
    }

    @Override
    public List<Enseignant> recupererEnseignantsParVille(String ville) {
        return repository.findByVille(ville);
    }

    @Override
    public long nombreEnseignants() {
        return repository.count();
    }
}
