package fr.univbrest.dosi.controller;


import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.business.PromotionBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

    private PromotionBusiness business;

    @Autowired
    public PromotionController(PromotionBusiness business) {
        this.business = business;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Promotion creerFromation(@RequestBody Promotion Promotion){
        return business.creerPromotion(Promotion);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Promotion> recupererPromotions(){
        return business.recupererPromotions();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/codeFormation/{codeFormation}/anneeUniversitaire/{anneeUniversitaire}")
    public Promotion recupererPromotionParCode(@PathVariable("codeFormation") String codeFormation, @PathVariable("anneeUniversitaire") String anneeUniversitaire){
        PromotionPK promotionPK = new PromotionPK(anneeUniversitaire,codeFormation);
        return business.recupererPromotionParID(promotionPK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/codeFormation/{codeFormation}/anneeUniversitaire/{anneeUniversitaire}")
    public void supprimerPromotionParCode(@PathVariable("codeFormation") String codeFormation, @PathVariable("anneeUniversitaire") String anneeUniversitaire){
        PromotionPK promotionPK = new PromotionPK(anneeUniversitaire,codeFormation);
        this.business.supprimerPromotion(promotionPK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "sigle/{siglePromotion}")
    public List<Promotion> recupererPromotionParNom(@PathVariable("siglePromotion") String siglePromotion){
        return this.business.recupererPromotionParSigle(siglePromotion);
    }

    @RequestMapping(method = RequestMethod.GET, value = "processusStage/{processusStage}")
    public List<Promotion> recupererPromotionParProcessusStage(@PathVariable("processusStage") String processusStage){
        return this.business.recupererPromotionsParProcessusStage(processusStage);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void modifierPromotion (@RequestBody Promotion promotion){
        this.business.modifierPromotion(promotion);
    }



}
