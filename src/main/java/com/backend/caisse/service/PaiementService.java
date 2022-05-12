package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.Paiement;
import com.backend.caisse.entities.PaiementAvecFacture;
import com.backend.caisse.entities.PaiementSansFacture;

public interface PaiementService {

  List<Paiement> ListerPaiements(Long numS);
}
