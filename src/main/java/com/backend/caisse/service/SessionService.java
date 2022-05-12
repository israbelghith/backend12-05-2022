package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Caisse;
import com.backend.caisse.entities.Caissier;
import com.backend.caisse.entities.SessionCaisse;

public interface SessionService {

    SessionCaisse CreerSession(SessionCaisse p);

    SessionCaisse fermerSession(Long nums);

    SessionCaisse OuvrirSession(Long nums);

    SessionCaisse consulterSession(Long id);

    List<SessionCaisse> listerSessionCaisses();
    
    SessionCaisse fermerJournal(Long id);

    List<SessionCaisse>listerSessionParEncaissementEtEtat(String etat);

    List<SessionCaisse> chercherParNumeroCaisse(String etat,Long id);

    List<SessionCaisse> chercherParCaissier(Long id);

    List<SessionCaisse> chercherParEtatETCaissier(String etat,Long id);

    SessionCaisse chercherParCaissierEtEtat(Long id,String etat);

    SessionCaisse modifierSessionParMontantEtNbFacture(SessionCaisse sessionCaisse);

    void annulerSession(double mt, Long numS);

   // void modifierSessionParMontantEtNbFacture(double montantE, Long nbFacture, Long numS);

    

}
