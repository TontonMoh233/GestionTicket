package com.TicketGest.Controller;

import com.TicketGest.Service.ApprenantService;
import com.TicketGest.Service.TicketService;
import com.TicketGest.entite.Apprenant;
import com.TicketGest.entite.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/apprenant")
public class ControllerApprenant {

    @Autowired
    private TicketService ticketService;

    //CREATION DE TICKET
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/addticket/{apprenantId}/pour/{formateurId}")
    public Ticket AjouterTicket(@RequestBody Ticket ticket,@PathVariable long apprenantId, @PathVariable long formateurId) {
        return this.ticketService.creeticket(ticket, apprenantId, formateurId);
    }

    //SUPPRESSION D'UN TICKET
    @DeleteMapping(path = "{id}")
    public void SupprimerTicket(@PathVariable Long id){
        this.ticketService.suppticket(id);
    }


    // AFFICHER UN TICKET

    @GetMapping(path ="{id}")
   public  Ticket lire (@PathVariable Long id){
        return this.ticketService.recuppticket(id);
    }
  // recuperer tous les ticket

    @GetMapping(path = "AffichageTicket")
    public List<Ticket> AfficherTout(Ticket ticket){
        return this.ticketService.afficheticket(ticket);
    }



}
