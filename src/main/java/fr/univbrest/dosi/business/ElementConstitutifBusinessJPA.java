package fr.univbrest.dosi.business;

import fr.univbrest.dosi.bean.ElementConstitutif;
import fr.univbrest.dosi.bean.ElementConstitutifPK;
import fr.univbrest.dosi.repositories.ElementConstitutifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ElementConstitutifBusinessJPA implements ElementConstitutifBusiness {

    private ElementConstitutifRepository repository;

    @Autowired
    public ElementConstitutifBusinessJPA(ElementConstitutifRepository repository) {
        this.repository = repository;
    }


    @Override
    public ElementConstitutif creerElementConstitutif(ElementConstitutif elementConstitutif) {
        return this.repository.save(elementConstitutif);
    }

    @Override
    public void modifierElementConstitutif(ElementConstitutif elementConstitutif) {
        this.repository.save(elementConstitutif);
    }

    @Override
    public void supprimerElementConstitutif(ElementConstitutifPK elementConstitutifPK) {
        this.repository.delete(elementConstitutifPK);
    }

    @Override
    public List<ElementConstitutif> recupererTousLesElementConstitutifs() {
        return (List<ElementConstitutif>) repository.findAll();
    }

    @Override
    public ElementConstitutif recupererElementConstitutifParID(ElementConstitutifPK elementConstitutifPK) {
        return this.repository.findOne(elementConstitutifPK);
    }

    @Override
    public long nombreElementConstitutif() {
        return this.repository.count();
    }
}
