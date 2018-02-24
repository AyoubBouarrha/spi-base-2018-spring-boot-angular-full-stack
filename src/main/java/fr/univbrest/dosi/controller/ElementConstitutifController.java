package fr.univbrest.dosi.controller;

import fr.univbrest.dosi.bean.ElementConstitutif;
import fr.univbrest.dosi.bean.ElementConstitutifPK;
import fr.univbrest.dosi.business.ElementConstitutifBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Elementconstitutif")
public class ElementConstitutifController {

    private ElementConstitutifBusiness business;

    @Autowired
    public ElementConstitutifController(ElementConstitutifBusiness business) {
        this.business = business;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ElementConstitutif creerElementConstitutif(@RequestBody ElementConstitutif elementConstitutif){
        return business.creerElementConstitutif(elementConstitutif);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ElementConstitutif> recupererElementConstitutifs(){
        return business.recupererTousLesElementConstitutifs();
    }

    @RequestMapping(method = RequestMethod.GET , value = "/codeFormation/{codeFormation}/codeUe/{codeUe}/codeEc/{codeEc}")
    public ElementConstitutif recupererElementConstitutifParId(@PathVariable("codeFormation") String codeFormation,@PathVariable("codeUe") String codeUe,@PathVariable("codeEc") String codeEc){
        return this.business.recupererElementConstitutifParID(new ElementConstitutifPK(codeFormation, codeUe, codeEc));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void modifierElementConstitutif(ElementConstitutif elementConstitutif){
        this.business.modifierElementConstitutif(elementConstitutif);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/codeFormation/{codeFormation}/codeUe/{codeUe}/codeEc/{codeEc}")
    public void supprimerElementConstituif(@PathVariable("codeFormation") String codeFormation,@PathVariable("codeUe") String codeUe,@PathVariable("codeEc") String codeEc){
        this.business.supprimerElementConstitutif(new ElementConstitutifPK(codeFormation, codeUe, codeEc));
    }

    @RequestMapping(method = RequestMethod.GET , value = "count")
    public long recupererNombreElementConstituifs(){
        return business.nombreElementConstitutif();
    }




}
