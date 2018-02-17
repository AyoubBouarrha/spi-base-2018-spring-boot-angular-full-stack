package fr.univbrest.dosi.business;


import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class FormationBusinessJPATest {


    private FormationBusinessJPA formationBusinessJPA;



    @Test
    public void doitCreerUneFormation(){
        FormationRepository formationRepository = new FormationRepositoryList();
        formationBusinessJPA = new FormationBusinessJPA(formationRepository);
        formationBusinessJPA.creerFormation(new Formation("44",new Date(),"Form1"));
        formationBusinessJPA.creerFormation(new Formation("45",new Date(),"Form2"));
        formationBusinessJPA.creerFormation(new Formation("46",new Date(),"Form3"));
        assertThat(formationRepository.count()).isEqualTo(3);
    }

    static class FormationRepositoryList implements FormationRepository{

        private List<Formation> formations;
        public FormationRepositoryList() {
            formations = new ArrayList<>();
        }

        @Override
        public List<Formation> findByNomFormation(String nomFormation) {
            return null;
        }

        @Override
        public <S extends Formation> S save(S s) {
            this.formations.add(s);
            return s;
        }

        @Override
        public <S extends Formation> Iterable<S> save(Iterable<S> iterable) {
            return null;
        }

        @Override
        public Formation findOne(String s) {
            return null;
        }

        @Override
        public boolean exists(String s) {
            return false;
        }

        @Override
        public Iterable<Formation> findAll() {
            return null;
        }

        @Override
        public Iterable<Formation> findAll(Iterable<String> iterable) {
            return null;
        }

        @Override
        public long count() {
            return this.formations.size();
        }

        @Override
        public void delete(String s) {

        }

        @Override
        public void delete(Formation formation) {

        }

        @Override
        public void delete(Iterable<? extends Formation> iterable) {

        }

        @Override
        public void deleteAll() {

        }

    }
}


