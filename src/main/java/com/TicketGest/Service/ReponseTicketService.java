package com.TicketGest.Service;

import com.TicketGest.Repositorie.ReponseRepository;
import com.TicketGest.entite.ReponseTicket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReponseTicketService {

    private ReponseRepository reponseRepository;

    public ReponseTicket AjouterReponse(ReponseTicket reponseTicket){
        return reponseRepository.save(reponseTicket);
    }
}
