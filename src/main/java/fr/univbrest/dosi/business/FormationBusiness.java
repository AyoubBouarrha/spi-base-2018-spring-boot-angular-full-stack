package fr.univbrest.dosi.business;

import fr.univbrest.dosi.bean.Formation;

import java.util.List;

public interface FormationBusiness {

    public Formation creerFormation(Formation formation);

    public void modifierFormation(Formation formation);

    void supprimerFormation(String codeFormation);

    List<Formation> recupererFormations();

    Formation recupererFromationParCode(String codeFormation);

    List<Formation> recupererFromationParNom(String nomFormation);

    long nombreFormations();



}
