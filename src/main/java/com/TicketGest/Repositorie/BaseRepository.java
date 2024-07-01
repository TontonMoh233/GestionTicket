package com.TicketGest.Repositorie;

import com.TicketGest.entite.BaseConnaissance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository extends JpaRepository<BaseConnaissance,Integer> {
}
