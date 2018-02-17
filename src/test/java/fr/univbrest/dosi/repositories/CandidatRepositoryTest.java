package fr.univbrest.dosi.repositories;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Candidat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class CandidatRepositoryTest {

    @Autowired
    CandidatRepository candidatRepository;


    @Before
    public void setupCandidats(){

        List<Candidat> listCandidat = new ArrayList<>();
        listCandidat.add(new Candidat("101","C1","c1","UBO"));
        listCandidat.add(new Candidat("102","C2","c2","UH1"));
        listCandidat.add(new Candidat("103","C3","c3","UH1"));
        listCandidat.add(new Candidat("104","C4","c4","UBO"));
        listCandidat.add(new Candidat("105","C5","c5","UH2"));
        listCandidat.add(new Candidat("106","C6","c6","UBO"));
        listCandidat.add(new Candidat("107","C7","c7","UH2"));

        candidatRepository.save(listCandidat);
    }

    @Test
    public void doitTrouverCandidat(){
        assertThat(candidatRepository.findByNom("C3").isEmpty()).isFalse();
    }

    @Test
    public void doitTrouverCandidatsByUnivOrigine(){
        assertThat(candidatRepository.findByUniversiteOrigine("UBO").size()).isEqualTo(3);
    }

}
