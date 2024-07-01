package com.TicketGest.Repositorie;

import com.TicketGest.entite.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprenantRepositorie extends JpaRepository<Apprenant,Long> {
    Apprenant findAllById(Long id);
}
