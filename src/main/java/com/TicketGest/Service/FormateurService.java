package com.TicketGest.Service;

import com.TicketGest.Repositorie.FormateurRepository;
import com.TicketGest.Repositorie.RoleRepository;
import com.TicketGest.entite.Formateur;
import com.TicketGest.entite.Role;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FormateurService {
    @Autowired
    private FormateurRepository formateurRepository;

    @Autowired
    private RoleRepository roleRepository;

    // AJOUT FORMATEUR
    public Formateur creeformateur(Formateur formateur){
        Role role = roleRepository.findByName("formateur");
        formateur.setRole(role);
        return this.formateurRepository.save(formateur);
    }

    // SUPPRIMER FORMATEUR

    public void SuppFormateur(Long id){
        this.formateurRepository.deleteById(id);
    }
    public Formateur lire(Long id){
        return this.formateurRepository.getById(id);
    }

    public List<Formateur> affiche(Formateur formateur) {
        return this.formateurRepository.findAll();
    }

    public Formateur miseJour(Long id, Formateur formateurDetails) {
        Optional<Formateur> optionnalapprenant = formateurRepository.findById(id);
        Formateur formateur = null;
        if (optionnalapprenant.isPresent()) {

            formateur = optionnalapprenant.get();
            formateur.setNom(formateurDetails.getNom());
            formateur.setPrenom(formateurDetails.getPrenom());
            formateur.setMot_de_passe(formateurDetails.getMot_de_passe());
            formateur.setEmail(formateurDetails.getEmail());
        }

        return formateurRepository.save((formateur));


    }
}