package com.backend.caisse.repos;

import java.util.List;

import com.backend.caisse.entities.Encaissement;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EncaissementRepository extends JpaRepository<Encaissement, Long> {


  @Transactional
  @Modifying
  @Query("update Encaissement e set e.etat='Annuler' where e.idE=?1")
  void updateEtatAnnulerEncaissement(long idp);

  @Transactional
  @Modifying
  @Query("update Paiement p set p.encaissement.idE=?1 where p.idP=?2")
  void updateEncaissementPaiement(Long enc, long idp);

  @Transactional
  @Modifying
  @Query("update Encaissement e set e.etat=?1, e.montantE= e.montantE -?2 where e.idE=?3")
  void modifierEncaissement(String e,double mt,long idp);

  List<Encaissement> findByEtatAndSessionNumS(String etat,Long num);

  List<Encaissement> findBySession(Long num);

  List<Encaissement> findBySessionNumS(Long num);

  List<Encaissement>findByEtatAndPaiementModePaiement(String e, String m);
}
