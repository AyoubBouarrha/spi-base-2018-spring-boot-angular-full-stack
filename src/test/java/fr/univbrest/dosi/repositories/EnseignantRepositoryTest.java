package fr.univbrest.dosi.repositories;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.business.EnseignantBusinessJPA;
import fr.univbrest.dosi.business.EnseignantBusinessJPATest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppTestConfig.class)
public class EnseignantRepositoryTest {

    @Autowired
    private EnseignantRepository enseignantRepository;


    @Before
    public void creationEnseignants(){
        enseignantRepository.save(new Enseignant(101L,"AAA","aaa","AAA.aaa@univ-brest.fr","BREST"));
        enseignantRepository.save(new Enseignant(102L,"BBB","bbb","BBB.bbb@univ-brest.fr","PARIS"));
        enseignantRepository.save(new Enseignant(103L,"CCC","ccc","CCC.ccc@univ-brest.fr","BREST"));
    }

    @Test
    public void doitCompterLesEnseignants(){
        long count = enseignantRepository.count();
        assertThat(count).isEqualTo(3);
    }


    @Test
    public void doitTrouverEnseignantParNom() {
        assertThat(enseignantRepository.findFirstByNom("AAA")).isNotNull();
    }

    @Test
    public void doitModifierEnseignant(){
        Enseignant enseignant = new Enseignant(103L, "CCC", "ccc","modified.ccc@univ-brest.fr","BREST");
        enseignantRepository.save(enseignant);
        Enseignant newEnseignant = enseignantRepository.findOne(103L);
        assertThat(newEnseignant.getEmailUbo()).isEqualTo("modified.ccc@univ-brest.fr");
    }

    @Test
    public void doitTrouverParEmailUBO(){
        assertThat(enseignantRepository.findFirstByEmailUbo("BBB.bbb@univ-brest.fr")).isNotNull();
    }

    @Test
    public void doitTrouverParVille(){
        assertThat(enseignantRepository.findByVille("BREST").size()).isEqualTo(2);
    }

    @Test
    public void doitSupprimerEnseignant() {
        System.out.println(enseignantRepository.findAll());
        enseignantRepository.delete(102L);
        assertThat(enseignantRepository.count()).isEqualTo(2L);
    }






}
