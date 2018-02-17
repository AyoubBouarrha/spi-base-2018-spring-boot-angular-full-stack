package fr.univbrest.dosi.business;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromotionBusinessJPA implements PromotionBusiness {

    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionBusinessJPA(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public Promotion creerPromotion(Promotion promotion) {
        return this.promotionRepository.save(promotion);
    }

    @Override
    public void modifierPromotion(Promotion promotion) {
        this.promotionRepository.save(promotion);
    }

    @Override
    public void supprimerPromotion(PromotionPK promotionPK) {
        this.promotionRepository.delete(promotionPK);
    }

    @Override
    public List<Promotion> recupererPromotions() {
        return (List<Promotion>) this.promotionRepository.findAll();
    }

    @Override
    public Promotion recupererPromotionParID(PromotionPK promotionPK) {
        return this.promotionRepository.findOne(promotionPK);
    }

    @Override
    public List<Promotion> recupererPromotionParSigle(String siglePromotion) {
        return this.promotionRepository.findBySiglePromotion(siglePromotion);
    }

    @Override
    public List<Promotion> recupererPromotionsParProcessusStage(String processusStage) {
        return this.promotionRepository.findByProcessusStage(processusStage);
    }

    @Override
    public long nombrePromotions() {
        return this.promotionRepository.count();
    }
}
