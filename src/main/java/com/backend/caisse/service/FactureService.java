package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.Paiement;

public interface FactureService {
    
    List<Facture> ChercherFactureParRefContrat(Long rfc);

    List<Facture> ChercherFactureParRefClient(Long rf);

    List<Facture> ChercherFactureParRefFacture(Long ff);

    List<Facture> ChercherFactureParSecteur(String adresse);

    void modifierFacture(Paiement paiement, Long ref);

    void annulerPaiementFacture(Long referenceFact);

    int chercherPaiementFacture(Paiement p);


}
