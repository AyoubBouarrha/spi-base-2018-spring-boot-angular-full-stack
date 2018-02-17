package fr.univbrest.dosi.repositories;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PromotionRepository extends CrudRepository<Promotion, PromotionPK> {
    List<Promotion> findBySiglePromotion (String siglePromotion);
    List<Promotion> findByProcessusStage (String processusStage);
}
