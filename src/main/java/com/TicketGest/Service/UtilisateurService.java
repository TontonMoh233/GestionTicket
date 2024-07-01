package com.TicketGest.Service;

import com.TicketGest.Repositorie.UtilisateurRepository;
import com.TicketGest.entite.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Service
public class UtilisateurService {
    private UtilisateurRepository utilisateurrepository;


    public Utilisateur creation(Utilisateur utilisateur){
      return this.utilisateurrepository.save(utilisateur);

    }
}
