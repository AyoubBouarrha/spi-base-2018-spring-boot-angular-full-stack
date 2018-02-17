package fr.univbrest.dosi.business;

import fr.univbrest.dosi.bean.Enseignant;

import java.util.List;

public interface EnseignantBusiness {

    Enseignant creerEnseignant(Enseignant enseignant);

    void modifierEnseignant(Enseignant enseignant);

    void supprimerEnseignant(long noEnseignant);

    List<Enseignant> recupererEnseignants();

    Enseignant recupererEnseignantParNum(long noEnseignant);

    Enseignant recupererEnseignantParNom(String nom);

    Enseignant recupererEnseignantParEmailUBO(String emailUBO);

    List<Enseignant> recupererEnseignantsParVille(String ville);

    long nombreEnseignants();
}
