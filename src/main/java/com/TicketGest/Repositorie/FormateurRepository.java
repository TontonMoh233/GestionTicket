package com.TicketGest.Repositorie;

import com.TicketGest.entite.Formateur;
import com.TicketGest.entite.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur,Long> {

}
