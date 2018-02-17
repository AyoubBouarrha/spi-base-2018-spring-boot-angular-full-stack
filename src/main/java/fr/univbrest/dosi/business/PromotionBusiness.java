package fr.univbrest.dosi.business;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;

import java.util.List;

public interface PromotionBusiness {

    public Promotion creerPromotion(Promotion promotion);

    public void modifierPromotion(Promotion promotion);

    void supprimerPromotion(PromotionPK promotionPK);

    List<Promotion> recupererPromotions();

    Promotion recupererPromotionParID(PromotionPK promotionPK);

    List<Promotion> recupererPromotionParSigle(String siglePromotion);

    List<Promotion> recupererPromotionsParProcessusStage(String processusStage);

    long nombrePromotions();
}
