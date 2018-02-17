package fr.univbrest.dosi.business;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class FormationBusinessJPA implements FormationBusiness {


    private FormationRepository formationRepository;

    @Autowired
    public FormationBusinessJPA(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    @Override
    public Formation creerFormation(Formation formation) {
        this.formationRepository.save(formation);
        return formation;
    }

    @Override
    public void modifierFormation(Formation formation) {
        this.formationRepository.save(formation);
    }

    @Override
    public void supprimerFormation(String codeFormation) {
        this.formationRepository.delete(codeFormation);
    }

    @Override
    public List<Formation> recupererFormations() {
        return (List<Formation>) this.formationRepository.findAll();
    }

    @Override
    public Formation recupererFromationParCode(String codeFormation) {
        return this.formationRepository.findOne(codeFormation);
    }

    @Override
    public List<Formation> recupererFromationParNom(String nomFormation) {
        return this.formationRepository.findByNomFormation(nomFormation);
    }
}
