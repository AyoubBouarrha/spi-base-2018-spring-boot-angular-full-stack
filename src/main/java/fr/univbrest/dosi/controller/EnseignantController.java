package fr.univbrest.dosi.controller;


import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.business.EnseignantBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enseignants")
@CrossOrigin
public class EnseignantController {

    private EnseignantBusiness business;

    @Autowired
    public EnseignantController(EnseignantBusiness business) {
        this.business = business;
    }

    //--Une Sequence doit être obligatoirement crée pour génerer un noEnseignant (script de la sequence : "create sequence t1_seq start with 20 increment by 1 nomaxvalue;")
    @RequestMapping(method = RequestMethod.POST)
    public Enseignant creerEnseignant(@RequestBody Enseignant enseignant){
        return business.creerEnseignant(enseignant);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Enseignant> recupererEnseignants(){
        return business.recupererEnseignants();
    }

    @RequestMapping(method = RequestMethod.GET , value = "count")
    public long recupererNombreEnseignants(){
        return business.nombreEnseignants();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{noEnseignant}")
    public Enseignant recupererEnseignantParCode(@PathVariable("noEnseignant") long noEnseignant){
        return business.recupererEnseignantParNum(noEnseignant);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/{noEnseignant}")
    public boolean supprimerEnseignant (@PathVariable("noEnseignant") long noEnseignant){
        try{
            this.business.supprimerEnseignant(noEnseignant);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "nom/{nom}")
    public Enseignant recupererEnseignantParNom(@PathVariable("nom") String nom){
        return this.business.recupererEnseignantParNom(nom);
    }

    @RequestMapping(method = RequestMethod.GET, value = "emailUBO/{emailUBO:.+}")
    public Enseignant recupererEnseignantParEmailUBO(@PathVariable("emailUBO") String emailUBO){
        return this.business.recupererEnseignantParEmailUBO(emailUBO);
    }

    @RequestMapping(method = RequestMethod.GET, value = "ville/{ville}")
    public List<Enseignant> recupererEnseignantsParVille(@PathVariable("ville") String ville){
        return this.business.recupererEnseignantsParVille(ville);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void modifierEnseignant(@RequestBody Enseignant enseignant){
        this.business.modifierEnseignant(enseignant);
    }
}
