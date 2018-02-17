package fr.univbrest.dosi.business;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repositories.CandidatRepository;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CandidatBusinessJPATest {

    private static CandidatBusinessJPA candidatBusinessJPA;
    private static CandidatRepository candidatRepository;

    @BeforeClass
    public static void setup() {
        candidatRepository = new CandidatRepositoryList();
        candidatBusinessJPA = new CandidatBusinessJPA(candidatRepository);
    }

    @Test
    public void doitCreerUnCandidat() {
        candidatBusinessJPA.creerCandidat(new Candidat("101", "C1", "c1", "UBO"));
        candidatBusinessJPA.creerCandidat(new Candidat("102", "C2", "c2", "UH1"));
        candidatBusinessJPA.creerCandidat(new Candidat("103", "C3", "c3", "UBO"));
        candidatBusinessJPA.creerCandidat(new Candidat("104", "C4", "c4", "UH1"));
        assertThat(candidatBusinessJPA.nombreCandidat()).isEqualTo(4L);
    }

    @Test
    public void doitSupprimerCandidat() {
        candidatBusinessJPA.supprimerCandidat("102");
        assertThat(candidatBusinessJPA.nombreCandidat()).isEqualTo(3L);
    }

    @Test
    public void doitTrouverCandidatByNom() {
        assertThat(candidatBusinessJPA.rechercheCandidatsParNom("C3").isEmpty()).isFalse();
    }

    @Test
    public void doitTrouverCandidatsByUnivOrigine() {
        assertThat(candidatBusinessJPA.rechercheCandidatsUniversiteOrigine("UBO").size()).isEqualTo(2);
    }

    static class CandidatRepositoryList implements CandidatRepository {

        private List<Candidat> candidats;

        public CandidatRepositoryList() {
            candidats = new ArrayList<>();
        }


        @Override
        public List<Candidat> findByNom(String nom) {
            return candidats.stream().filter(c -> c.getNom().equals(nom)).collect(Collectors.toList());
        }

        @Override
        public List<Candidat> findByUniversiteOrigine(String universiteOrigine) {
            return candidats.stream().filter(c -> c.getUniversiteOrigine().equals(universiteOrigine)).collect(Collectors.toList());
        }

        @Override
        public <S extends Candidat> S save(S s) {
            this.candidats.add(s);
            return s;
        }

        @Override
        public <S extends Candidat> Iterable<S> save(Iterable<S> iterable) {
            return null;
        }

        @Override
        public Candidat findOne(String noCandidat) {
            for (Candidat candidat : candidats)
                if (candidat.getNoCandidat().equals(noCandidat))
                    return candidat;
            return null;
        }

        @Override
        public boolean exists(String s) {
            return false;
        }

        @Override
        public Iterable<Candidat> findAll() {
            return null;
        }

        @Override
        public Iterable<Candidat> findAll(Iterable<String> iterable) {
            return null;
        }

        @Override
        public long count() {
            return this.candidats.size();
        }

        @Override
        public void delete(String noCandidat) {
            candidats.removeIf(candidat -> candidat.getNoCandidat().equals(noCandidat));
        }

        @Override
        public void delete(Candidat candidat) {

        }

        @Override
        public void delete(Iterable<? extends Candidat> iterable) {

        }

        @Override
        public void deleteAll() {

        }
    }

}
