package com.TicketGest.Repositorie;

import com.TicketGest.entite.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepositorie extends JpaRepository<Ticket,Integer> {
    void deleteById(Long id);

    Ticket findById(Long id);
}
