package com.TicketGest.entite;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name ="ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String description;
    private String categorie;
    private String priorité;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    Apprenant apprenant;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    Formateur formateur;

    @OneToMany(mappedBy = "ticket")
    List<ReponseTicket> reponseticket;



}
