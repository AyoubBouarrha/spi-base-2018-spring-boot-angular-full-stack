package fr.univbrest.dosi.business;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repositories.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CandidatBusinessJPA implements CandidatBusiness {


    private CandidatRepository candidatRepository;


    @Autowired
    public CandidatBusinessJPA(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    @Override
    public Candidat creerCandidat(Candidat candidat) {
        this.candidatRepository.save(candidat);
        return candidat;
    }

    @Override
    public void modifierCandidat(Candidat candidat) {
        this.candidatRepository.save(candidat);
    }

    @Override
    public void supprimerCandidat(String noCandidat) {
        this.candidatRepository.delete(noCandidat);

    }

    @Override
    public List<Candidat> recupererTousLesCandidats() {
        return (List<Candidat>) this.candidatRepository.findAll();
    }

    @Override
    public List<Candidat> rechercheCandidatsParNom(String nom) {
        return this.candidatRepository.findByNom(nom);
    }

    @Override
    public List<Candidat> rechercheCandidatsUniversiteOrigine(String universiteOrigine) {
        return this.candidatRepository.findByUniversiteOrigine(universiteOrigine);
    }

    @Override
    public Candidat recupererCandidatParCode(String noCandidat) {
        return this.candidatRepository.findOne(noCandidat);
    }

    @Override
    public long nombreCandidat() {
        return this.candidatRepository.count();
    }
}
