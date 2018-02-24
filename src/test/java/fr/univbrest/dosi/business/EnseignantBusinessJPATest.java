package fr.univbrest.dosi.business;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class EnseignantBusinessJPATest {

    private  EnseignantBusinessJPA enseignantBusinessJPA;
    private  EnseignantRepository enseignantRepository;


    @Before
    public void creationDesEnseignant() {

        enseignantRepository = new EnseignantRepositroeyList();
        enseignantBusinessJPA = new EnseignantBusinessJPA(enseignantRepository);

        enseignantBusinessJPA.creerEnseignant(new Enseignant(1, "AAA", "aaa","AAA.aaa@univ-brest.fr","BREST"));
        enseignantBusinessJPA.creerEnseignant(new Enseignant(2, "BBB", "bbb","BBB.bbb@univ-brest.fr","PARIS"));
        enseignantBusinessJPA.creerEnseignant(new Enseignant(3, "CCC", "ccc","CCC.ccc@univ-brest.fr","BREST"));
        assertThat(enseignantBusinessJPA.nombreEnseignants()).isEqualTo(3L);
    }



    @Test
    public void doitTrouverEnseignantParNom() {
        assertThat(enseignantBusinessJPA.recupererEnseignantParNom("AAA")).isNotNull();
    }

    @Test
    public void doitModifierEnseignant(){
        Enseignant enseignant = new Enseignant(3, "CCC", "ccc","modified.ccc@univ-brest.fr","BREST");
        enseignantBusinessJPA.modifierEnseignant(enseignant);
        Enseignant newEnseignant = enseignantBusinessJPA.recupererEnseignantParNum(3);
        assertThat(newEnseignant.getEmailUbo()).isEqualTo("modified.ccc@univ-brest.fr");
    }

    @Test
    public void doitTrouverParEmailUBO(){
        assertThat(enseignantBusinessJPA.recupererEnseignantParEmailUBO("BBB.bbb@univ-brest.fr")).isNotNull();
    }

    @Test
    public void doitTrouverParVille(){
        assertThat(enseignantBusinessJPA.recupererEnseignantsParVille("BREST").size()).isEqualTo(2);
    }

    @Test
    public void doitSupprimerEnseignant() {
        enseignantBusinessJPA.supprimerEnseignant(2);
        assertThat(enseignantBusinessJPA.nombreEnseignants()).isEqualTo(2L);
    }

    class EnseignantRepositroeyList implements EnseignantRepository {

        private List<Enseignant> enseignants;

        public EnseignantRepositroeyList() {
            this.enseignants = new ArrayList<>();
        }

        @Override
        public List<Enseignant> findFirstByNom(String nom) {
            return enseignants.stream().filter(e -> e.getNom().equals(nom)).collect(Collectors.toList());
        }

        @Override
        public List<Enseignant> findFirstByEmailUbo(String emailUBO) {
            return enseignants.stream().filter(e -> e.getEmailUbo().equals(emailUBO)).collect(Collectors.toList());
        }

        @Override
        public List<Enseignant> findByVille(String ville) {
            return enseignants.stream().filter(e -> e.getVille().equals(ville)).collect(Collectors.toList());
        }

        @Override
        public <S extends Enseignant> S save(S s) {
            if (!this.enseignants.contains(s))//ajout
                this.enseignants.add(s);
            else{//modificiation
                enseignants.remove(s);
                enseignants.add(s);
            }
            return s;
        }

        @Override
        public <S extends Enseignant> Iterable<S> save(Iterable<S> iterable) {
            return null;
        }

        @Override
        public Enseignant findOne(Long noEnseignant) {
            for (Enseignant enseignant : enseignants)
                if (enseignant.getNoEnseignant()==noEnseignant)
                    return enseignant;
            return null;
        }

        @Override
        public boolean exists(Long aLong) {
            return false;
        }

        @Override
        public Iterable<Enseignant> findAll() {
            return null;
        }

        @Override
        public Iterable<Enseignant> findAll(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public long count() {
            return this.enseignants.size();
        }

        @Override
        public void delete(Long noEnseignant) {
            enseignants.removeIf(enseignant -> enseignant.getNoEnseignant() == noEnseignant);
        }

        @Override
        public void delete(Enseignant enseignant) {
        }

        @Override
        public void delete(Iterable<? extends Enseignant> iterable) {

        }

        @Override
        public void deleteAll() {

        }
    }
}
