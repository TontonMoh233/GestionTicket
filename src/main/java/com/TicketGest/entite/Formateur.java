package com.TicketGest.entite;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(
        name = "formateur"
)
public class Formateur extends Utilisateur{


    @OneToMany(mappedBy  ="formateur")
    List<Ticket> ticket;

    @OneToMany(mappedBy  ="formateur")
    List<Apprenant> apprenant;

    @OneToMany(mappedBy = "formateur")
    List<BaseConnaissance> baseconnaissance;

    @ManyToOne
    @JoinColumn(name="admin_id")
    Admin admin;

    @OneToMany(mappedBy = "formateur")
    List<Notification>notification;

    @OneToMany(mappedBy = "formateur")
    List<ReponseTicket> reponses;
}
