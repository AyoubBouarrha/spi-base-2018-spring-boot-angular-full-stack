package fr.univbrest.dosi.controller;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.FormationBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formations")
public class FormationController {

    private FormationBusiness business;

    @Autowired
    public FormationController(FormationBusiness business) {
        this.business = business;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Formation creerFromation(@RequestBody Formation formation){
        return business.creerFormation(formation);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Formation> recupererFormations(){
        return business.recupererFormations();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{codeFormation}")
    public Formation recupererFormatoinParCode(@PathVariable("codeFormation") String codeFormation){
        return business.recupererFromationParCode(codeFormation);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/{codeFormation}")
    public void supprimerFormation (@PathVariable("codeFormation") String codeFormation){
        this.business.supprimerFormation(codeFormation);
    }

    @RequestMapping(method = RequestMethod.GET, value = "nom/{nomFormation}")
    public List<Formation> recupererFromationParNom(@PathVariable("nomFormation") String nomFormation){
        return this.business.recupererFromationParNom(nomFormation);
    }

}
