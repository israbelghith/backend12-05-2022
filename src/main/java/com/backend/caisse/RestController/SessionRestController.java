package com.backend.caisse.RestController;

import java.util.List;

import com.backend.caisse.entities.Caisse;
import com.backend.caisse.entities.Caissier;
import com.backend.caisse.entities.SessionCaisse;
import com.backend.caisse.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
@CrossOrigin(origins = "*")
public class SessionRestController {
    @Autowired
    SessionService sessionService;

    @RequestMapping(path = "/listerSessionCaisses", method = RequestMethod.GET)
    public  ResponseEntity<Object>  listerSessionCaisses() {
        try{
            return new ResponseEntity<Object>(sessionService.listerSessionCaisses(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/chercherParCaissierId/{id}", method = RequestMethod.GET)
    public  ResponseEntity<Object>  chercherParCaissierId(@PathVariable("id") Long id) {
        try{
            return new ResponseEntity<Object>(sessionService.chercherParCaissier(id),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/chercherParCaisseNumC/{etat}/{numc}", method = RequestMethod.GET)
    public  ResponseEntity<Object>  chercherParCaisseNumC(@PathVariable("etat") String etat,@PathVariable("numc") Long numc) {
        try{
            return new ResponseEntity<Object>(sessionService.chercherParNumeroCaisse(etat,numc),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/chercherParEtatETCaissier/{etat}/{id}", method = RequestMethod.GET)
    public  ResponseEntity<Object>  chercherParEtatETCaissier(@PathVariable("etat") String etat,@PathVariable("id") Long id) {
        try{
            return new ResponseEntity<Object>(sessionService.chercherParEtatETCaissier(etat,id),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/chercherParCaissierEtEtat/{id}/{etat}", method = RequestMethod.GET)
    public  ResponseEntity<Object>  chercherParCaissierETEtat(@PathVariable("id") Long id,@PathVariable("etat") String etat) {
        try{
            return new ResponseEntity<Object>(sessionService.chercherParCaissierEtEtat(id,etat),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    
   
    
    
    @RequestMapping(path = "/listerSessionParEncaissementEtat/{etat}", method = RequestMethod.GET)
    public  ResponseEntity<Object>  listerSessionParEncaissementEtat(@PathVariable("etat") String etat) {
        try{
            return new ResponseEntity<Object>(sessionService.listerSessionParEncaissementEtEtat(etat),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/consulterSessionCaisse/{nums}", method = RequestMethod.GET)
    public  ResponseEntity<Object>  cosulterSessionCaisse(@PathVariable("nums") Long nums) {
        try{
            return new ResponseEntity<Object>(sessionService.consulterSession(nums),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/creerSessionCaisse",method = RequestMethod.POST)
    public  ResponseEntity<Object>  creerSessionCaisse(@RequestBody SessionCaisse SessionCaisse) {
        try{
            return new ResponseEntity<Object>(sessionService.CreerSession(SessionCaisse),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/fermerSessionParNum/{nums}",method = RequestMethod.PUT)
    public ResponseEntity<Object> fermerSessionParId(@PathVariable("nums") Long nums) {
        try{
            return new ResponseEntity<Object>(sessionService.fermerSession(nums),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

 

    @RequestMapping(value = "/OuvrirSessionParNum/{nums}",method = RequestMethod.PUT)
    public ResponseEntity<Object> ouvrirSessionCaisse(@PathVariable("nums") Long nums) {
        try{
            return new ResponseEntity<Object>(sessionService.OuvrirSession(nums),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @RequestMapping(value = "/fermerJournalCaisse/{nums}",method = RequestMethod.PUT)
    public ResponseEntity<Object> fermerJournalCaisse(@PathVariable("nums") Long nums) {
        try{
            return new ResponseEntity<Object>(sessionService.fermerJournal(nums),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    @RequestMapping(value = "/modifierSessionCaisse",method = RequestMethod.PUT)
    public ResponseEntity<Object> ModifierSessionCaisse(@RequestBody SessionCaisse sessionCaisse) {
        try{
            return new ResponseEntity<Object>(sessionService.modifierSessionParMontantEtNbFacture(sessionCaisse),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

}
