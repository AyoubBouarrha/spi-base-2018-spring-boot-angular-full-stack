package fr.univbrest.dosi.business;


import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repositories.FormationRepository;
import fr.univbrest.dosi.repositories.PromotionRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class PromotionBusinessJPATest {

    private PromotionBusinessJPA promotionBusinessJPA;
    private PromotionRepository promotionRepository;

    private FormationBusinessJPA formationBusinessJPA;
    private FormationRepository formationRepository;

    @Before
    public void creationDesPromotion(){
        promotionRepository = new PromotionRepositoryList();
        promotionBusinessJPA = new PromotionBusinessJPA(promotionRepository);

        formationRepository = new FormationBusinessJPATest.FormationRepositoryList();
        formationBusinessJPA = new FormationBusinessJPA(formationRepository);


        formationBusinessJPA.creerFormation(new Formation("35",new Date(),"Form1"));
        formationBusinessJPA.creerFormation(new Formation("36",new Date(),"Form2"));
        formationBusinessJPA.creerFormation(new Formation("37",new Date(),"Form3"));

        promotionBusinessJPA.creerPromotion(new Promotion(new PromotionPK("2018-2019","35"),"Form2018","EC"));
        promotionBusinessJPA.creerPromotion(new Promotion(new PromotionPK("2019-2020","36"),"Form2019","RECH"));
        promotionBusinessJPA.creerPromotion(new Promotion(new PromotionPK("2020-2021","37"),"Form2020","EC"));

    }

    @Test
    public void doitTrouverPromotionParNom() {
        assertThat(promotionBusinessJPA.recupererPromotionParSigle("Form2018")).isNotNull();
    }

    @Test
    public void doitModifierPromotion(){
        Promotion promotion = new Promotion(new PromotionPK("2020-2021","37"),"Form20Modified","EC");
        promotionBusinessJPA.modifierPromotion(promotion);
        Promotion newPromotion = promotionBusinessJPA.recupererPromotionParID(new PromotionPK("2020-2021","37"));
        assertThat(newPromotion.getSiglePromotion()).isEqualTo("Form20Modified");
    }

    @Test
    public void doitTrouverParSigle(){
        assertThat(promotionBusinessJPA.recupererPromotionParSigle("Form2019")).isNotNull();
    }

    @Test
    public void doitTrouverPromotionParProcessusStage(){
        assertThat(promotionBusinessJPA.recupererPromotionsParProcessusStage("EC").size()).isEqualTo(2);
    }

    @Test
    public void doitCompterLesPromotions() {
        long count = promotionBusinessJPA.nombrePromotions();
        assertThat(count).isEqualTo(3L);
    }

    @Test
    public void doitSupprimerEnseignant() {
        promotionBusinessJPA.supprimerPromotion(new PromotionPK("2019-2020","36"));
        assertThat(promotionRepository.count()).isEqualTo(2L);
    }


    class PromotionRepositoryList implements PromotionRepository{

        private List<Promotion> promotions;

        public PromotionRepositoryList() {
            this.promotions = new ArrayList<>();
        }

        @Override
        public List<Promotion> findBySiglePromotion(String siglePromotion) {
            return promotions.stream().filter(p -> p.getSiglePromotion().equals(siglePromotion)).collect(Collectors.toList());
        }

        @Override
        public List<Promotion> findByProcessusStage(String processusStage) {
            return promotions.stream().filter(p -> p.getProcessusStage().equals(processusStage)).collect(Collectors.toList());
        }

        @Override
        public <S extends Promotion> S save(S s) {
            if (!this.promotions.contains(s))//ajout
                this.promotions.add(s);
            else{//modificiation
                promotions.remove(s);
                promotions.add(s);
            }
            return s;
        }

        @Override
        public <S extends Promotion> Iterable<S> save(Iterable<S> iterable) {
            return null;
        }

        @Override
        public Promotion findOne(PromotionPK promotionPK) {
            for (Promotion promotion : promotions)
                if (promotion.getId().equals(promotionPK))
                    return promotion;
            return null;
        }

        @Override
        public boolean exists(PromotionPK promotionPK) {
            return false;
        }

        @Override
        public Iterable<Promotion> findAll() {
            return null;
        }

        @Override
        public Iterable<Promotion> findAll(Iterable<PromotionPK> iterable) {
            return null;
        }

        @Override
        public long count() {
            return this.promotions.size();
        }

        @Override
        public void delete(PromotionPK promotionPK) {
            promotions.removeIf(promotion -> promotion.getId().equals(promotionPK));
        }

        @Override
        public void delete(Promotion promotion) {

        }

        @Override
        public void delete(Iterable<? extends Promotion> iterable) {

        }

        @Override
        public void deleteAll() {

        }
    }

}
