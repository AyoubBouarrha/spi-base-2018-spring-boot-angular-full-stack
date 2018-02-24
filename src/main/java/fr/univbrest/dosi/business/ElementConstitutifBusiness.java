package fr.univbrest.dosi.business;

import fr.univbrest.dosi.bean.ElementConstitutif;
import fr.univbrest.dosi.bean.ElementConstitutifPK;

import java.util.List;

public interface ElementConstitutifBusiness {

    ElementConstitutif creerElementConstitutif(ElementConstitutif elementConstitutif);

    void modifierElementConstitutif(ElementConstitutif elementConstitutif);

    void supprimerElementConstitutif(ElementConstitutifPK elementConstitutifPK);

    List<ElementConstitutif> recupererTousLesElementConstitutifs();

    ElementConstitutif recupererElementConstitutifParID(ElementConstitutifPK elementConstitutifPK);

    long nombreElementConstitutif();

}
