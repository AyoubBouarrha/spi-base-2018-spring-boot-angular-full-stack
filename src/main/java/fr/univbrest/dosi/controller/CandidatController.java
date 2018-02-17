package fr.univbrest.dosi.controller;


import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.business.CandidatBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidats")
public class CandidatController {


    private CandidatBusiness business;

    @Autowired
    public CandidatController(CandidatBusiness business) {
        this.business = business;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Candidat> recupererCandidats(){
        return business.recupererTousLesCandidats();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Candidat creerCandidat(@RequestBody Candidat candidat){
        return business.creerCandidat(candidat);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{noCandidat}")
    public Candidat recupererFormatoinParCode(@PathVariable("noCandidat") String noCandidat){
        return business.recupererCandidatParCode(noCandidat);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/{noCandidat}")
    public void supprimerFormation (@PathVariable("noCandidat") String noCandidat){
        this.business.supprimerCandidat(noCandidat);
    }

    @RequestMapping(method = RequestMethod.GET, value = "nom/{nom}")
    public List<Candidat> recupererCandidatParNom(@PathVariable("nom") String nom){
        return this.business.rechercheCandidatsParNom(nom);
    }

}
