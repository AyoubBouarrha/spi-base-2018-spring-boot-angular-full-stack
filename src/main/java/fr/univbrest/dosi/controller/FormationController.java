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
    public Formation creerFromation(@RequestBody Formation formation) {
        if(business.recupererFromationParCode(formation.getCodeFormation())!=null){
            System.out.println("dddd");
            return null;
        }

        try {
            return business.creerFormation(formation);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Formation> recupererFormations() {
        return business.recupererFormations();
    }

    @RequestMapping(method = RequestMethod.GET , value = "count")
    public long recupererNombreEnseignants(){
        return business.nombreFormations();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{codeFormation}")
    public Formation recupererFormatoinParCode(@PathVariable("codeFormation") String codeFormation) {
        return business.recupererFromationParCode(codeFormation);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{codeFormation}")
    public boolean supprimerFormation(@PathVariable("codeFormation") String codeFormation) {
        try{
            this.business.supprimerFormation(codeFormation);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "nom/{nomFormation}")
    public List<Formation> recupererFromationParNom(@PathVariable("nomFormation") String nomFormation) {
        return this.business.recupererFromationParNom(nomFormation);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void modifierEnseignant(@RequestBody Formation formation){
        this.business.modifierFormation(formation);
    }

}
