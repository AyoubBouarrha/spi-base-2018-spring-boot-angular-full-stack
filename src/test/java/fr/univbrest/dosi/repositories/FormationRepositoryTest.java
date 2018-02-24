package fr.univbrest.dosi.repositories;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Formation;
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
public class FormationRepositoryTest {

    @Autowired
    FormationRepository formationRepository;

    @Before
    public void setup (){
        formationRepository.save(new Formation("35",new Date(),"Form1"));
    }

    @Test
    public void doitCompterLesFormation() {
        long count = formationRepository.count();

        assertThat(count).isEqualTo(1);
    }

    @Test
    public void doitTrouverFormation(){
        assertThat(formationRepository.findByNomFormation("Form1").isEmpty()).isFalse();
    }


}
