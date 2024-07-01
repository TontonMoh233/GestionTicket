package com.TicketGest.configuration;

import com.TicketGest.Repositorie.UtilisateurRepository;
import com.TicketGest.entite.Utilisateur;
import jdk.jshell.execution.Util;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DetailServiceImpl implements UserDetailsService {

    private UtilisateurRepository utilisateurRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur u = utilisateurRepository.findByEmail(email);
        System.out.println(u.getEmail());
        System.out.println(u.getMot_de_passe());
        System.out.println("Hello1");



        return User.
                withUsername(u.getEmail()).
                password(u.getMot_de_passe()).
                roles(u.getRole().getName()).
                build();
    }
}
