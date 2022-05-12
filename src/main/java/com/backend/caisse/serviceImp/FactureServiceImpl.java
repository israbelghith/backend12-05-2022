package com.backend.caisse.serviceImp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.Paiement;
import com.backend.caisse.repos.FactureRepository;
import com.backend.caisse.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactureServiceImpl implements FactureService {

    @Autowired
    FactureRepository factureRepository;

    @Override
    public List<Facture> ChercherFactureParRefContrat(Long rfc) {
        return factureRepository.findByContratReferenceContrat(rfc);
    }

    @Override
    public List<Facture> ChercherFactureParRefClient(Long rf) {
        return factureRepository.findByClientReferenceClient(rf);
    }

    @Override
    public List<Facture> ChercherFactureParRefFacture(Long ff) {
        return factureRepository.findByReferenceFact(ff);
    }

    @Override
    public void modifierFacture(Paiement paiement, Long ref) {
        factureRepository.updateFacturePayer(paiement, ref);

    }

    @Override
    public void annulerPaiementFacture(Long referenceFact) {
        factureRepository.updateFactureAnnuler(referenceFact);

    }

    @Override
    public int chercherPaiementFacture(Paiement p) {
        return factureRepository.chercherPaiementFacture(p.getIdP());
    }

    @Override
    public List<Facture> ChercherFactureParSecteur(String adresse) {

        return factureRepository.findByClientAdresseAndDateF(adresse,LocalDate.now());
    }
}
