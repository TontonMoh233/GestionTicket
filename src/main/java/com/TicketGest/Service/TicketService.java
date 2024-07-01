package com.TicketGest.Service;

import com.TicketGest.Repositorie.ApprenantRepositorie;
import com.TicketGest.Repositorie.FormateurRepository;
import com.TicketGest.Repositorie.TicketRepositorie;
import com.TicketGest.entite.Apprenant;
import com.TicketGest.entite.Formateur;
import com.TicketGest.entite.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepositorie ticketRepositorie;

    @Autowired
    private ApprenantRepositorie apprenantRepositorie;
    @Autowired
    private FormateurRepository formateurRepository;


    // CREATION d'un Ticket

    public Ticket creeticket(Ticket ticket, long apprenantId, long formateurId) {
        Apprenant apprenant = apprenantRepositorie.findById(apprenantId).orElse(null);
        Formateur formateur = formateurRepository.findById(formateurId).orElse(null);

        if (apprenant != null && formateur!= null){
            ticket.setDate(new Date());
            ticket.setApprenant(apprenant);
            ticket.setFormateur(formateur);
        }

        return this.ticketRepositorie.save(ticket);
    }
   // SUPPRIMER UN TICKET
    public void suppticket(Long id) {
        this.ticketRepositorie.deleteById(id);
    }

    public Ticket recuppticket(Long id) {

        return this.ticketRepositorie.findById(id);


    }


    public List<Ticket> afficheticket(Ticket ticket) {
        return this.ticketRepositorie.findAll();
    }
}