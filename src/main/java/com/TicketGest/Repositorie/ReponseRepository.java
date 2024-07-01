package com.TicketGest.Repositorie;

import com.TicketGest.entite.BaseConnaissance;
import com.TicketGest.entite.ReponseTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReponseRepository extends JpaRepository<ReponseTicket,Integer> {
}
