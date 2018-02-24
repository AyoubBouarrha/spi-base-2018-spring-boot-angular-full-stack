package fr.univbrest.dosi.repositories;


import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppTestConfig.class)
public class PromotionRepositoryTest {

    @Autowired
    PromotionRepository promotionRepository;

    @Autowired
    FormationRepository formationRepository;



    @Before
    public void creationDesPromotions(){
        formationRepository.save(new Formation("35",new Date(),"Form1"));
        formationRepository.save(new Formation("36",new Date(),"Form2"));
        formationRepository.save(new Formation("37",new Date(),"Form3"));

        promotionRepository.save(new Promotion(new PromotionPK("2018-2019","35"),"Form2018","EC"));
        promotionRepository.save(new Promotion(new PromotionPK("2019-2020","36"),"Form2019","RECH"));
        promotionRepository.save(new Promotion(new PromotionPK("2020-2021","37"),"Form2020","EC"));
    }


    @Test
    public void doitTrouverPromotionParNom() {
        assertThat(promotionRepository.findBySiglePromotion("Form2018")).isNotNull();
    }

    @Test
    public void doitModifierPromtion(){
        Promotion promotion = new Promotion(new PromotionPK("2020-2021","37"),"Form20Modified","EC");
        promotionRepository.save(promotion);
        Promotion newPromotion = promotionRepository.findOne(new PromotionPK("2020-2021","37"));
        assertThat(newPromotion.getSiglePromotion()).isEqualTo("Form20Modified");
    }

    @Test
    public void doitTrouverParSigle(){
        assertThat(promotionRepository.findBySiglePromotion("Form2019")).isNotNull();
    }

    @Test
    public void doitTrouverParProcessusStage(){
        assertThat(promotionRepository.findByProcessusStage("EC").size()).isEqualTo(2);
    }

    @Test
    public void doitCompterLesPromotion() {
        long count = promotionRepository.count();
        assertThat(count).isEqualTo(3L);
    }

    @Test
    public void doitSupprimerPromotion() {
        promotionRepository.delete(new PromotionPK("2019-2020","36"));
        assertThat(promotionRepository.count()).isEqualTo(2L);
    }





}
