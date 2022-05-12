package com.backend.caisse.repos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.backend.caisse.entities.Client;
import com.backend.caisse.entities.Contrat;
import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.Paiement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FactureRepository extends JpaRepository<Facture, Long> {

    List<Facture> findByClientReferenceClient(Long refcli);

    List<Facture> findByContratReferenceContrat(Long refCont);

    List<Facture> findByReferenceFact(Long ff);
    

    List<Facture> findByClientAdresseAndDateF(String adresse,LocalDate d);

 /*   @Transactional
    @Modifying
    @Query("select * from Facture f where f.client.adresse=?1")
    List<Facture> chercherFactureParSecteurEtDate(String secteur, LocalDate d);
*/
    @Transactional
    @Modifying
    @Query("update Facture f set f.etat='Payé' , f.paiement=?1 where f.referenceFact=?2")
    void updateFacturePayer(Paiement paie, long ff);

    @Transactional
    @Modifying
    @Query("update Facture f set f.etat='impayé', f.paiement=null where f.referenceFact=?1")
    void updateFactureAnnuler(long ff);



    @Query("SELECT COUNT(f.IdF) from Facture f  where f.paiement.idP= ?1")
    int chercherPaiementFacture(Long p);
}
