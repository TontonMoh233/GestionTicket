package com.TicketGest.Controller;

import com.TicketGest.Service.ApprenantService;
import com.TicketGest.Service.FormateurService;
import com.TicketGest.Service.ReponseTicketService;
import com.TicketGest.entite.Apprenant;
import com.TicketGest.entite.ReponseTicket;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/formateur")
@AllArgsConstructor
public class FormateurController {

    private FormateurService formateurService;
    private ApprenantService apprenantService;
    private ReponseTicketService reponseTicketService;

      // AJOUTER APPRENANT
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/AjouterApprenant")
    public Apprenant ajoutApprenant(@RequestBody Apprenant apprenant) {
        return this.apprenantService.ajout(apprenant);
    }

    // SUPPRIMER APPRENANT

    @DeleteMapping(path = "{id}")
    public void SupprimerApprenant(@PathVariable Long id){
        this.apprenantService.SuppApprenant(id);
    }

    // LIRE UN APPRENANT
    @GetMapping(path = "/recupp/{id}")
    public Apprenant lire(@PathVariable Long id){
        return  this.apprenantService.recup(id);
    }

    // RECUPERER TOUS LES APPRENANTS

    @GetMapping(path = "/Affichage")
    public List<Apprenant> AfficherApprenant(Apprenant apprenant){
        return this.apprenantService.afficheapprenant(apprenant);
    }

    // modifier Apprenant

    @PutMapping("/modiffapprenant/{id}")
    public Apprenant modifierStudent(@PathVariable Long id , @RequestBody Apprenant apprenantDetails){
        return apprenantService.uppdatyp(id,apprenantDetails);
    }

    @PostMapping("/AjouterReponse")
    public ReponseTicket AjouterReponse(@RequestBody ReponseTicket reponseTicket){
        return reponseTicketService.AjouterReponse( reponseTicket);
    }
}




