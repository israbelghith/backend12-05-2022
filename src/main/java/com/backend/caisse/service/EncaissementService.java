package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Encaissement;


public interface EncaissementService {

    List<Encaissement> listerEncaissements();

   List<Encaissement> listerEncaissementsParEtatETSession(String etat,Long nums);

    List<Encaissement> listerEncaissementsParSession(Long nums);

    List<Encaissement> listerEncaissementParEtatEtModePaiement(String e,String m);

    Encaissement ajouterEncaissement(Encaissement encaissement);

    void modifierEncaissement(String e,double mts, Long idE);
    
}
