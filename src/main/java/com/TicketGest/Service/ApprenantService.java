package com.TicketGest.Service;

import com.TicketGest.Repositorie.ApprenantRepositorie;
import com.TicketGest.Repositorie.RoleRepository;
import com.TicketGest.entite.Apprenant;
import com.TicketGest.entite.Role;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApprenantService<optional> {

  private ApprenantRepositorie apprenantRepository;
  private RoleRepository roleRepository;
  private PasswordEncoder passwordEncoder;


  public Apprenant ajout(Apprenant apprenant) {
    Role role = roleRepository.findByName("Apprenant");
    apprenant.setRole(role);
    apprenant.setMot_de_passe(passwordEncoder.encode(apprenant.getMot_de_passe()));
    return this.apprenantRepository.save(apprenant);
  }

  public void SuppApprenant(Long id) {

    this.apprenantRepository.deleteById(id);
  }

  public Apprenant recup(Long id) {
    return this.apprenantRepository.getById(id);
  }

  public List<Apprenant> afficheapprenant(Apprenant apprenant) {
    return this.apprenantRepository.findAll();
  }

  public Apprenant uppdatyp(Long id, Apprenant apprenantDetails) {

    Optional<Apprenant> optionalApprenant = apprenantRepository.findById(id);


    Apprenant apprenant = null;
    if (optionalApprenant.isPresent()) {

      apprenant = optionalApprenant.get();

      apprenant.setNom(apprenantDetails.getNom());
      apprenant.setPrenom(apprenantDetails.getPrenom());
      apprenant.setMot_de_passe( apprenantDetails.getMot_de_passe());
      apprenant.setEmail(apprenantDetails.getEmail());
    }

    return apprenantRepository.save(apprenant);
  }
  }











