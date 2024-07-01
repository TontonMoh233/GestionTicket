package com.TicketGest.entite;

import jakarta.persistence.*;

@Entity
@Table(name = "baseconnaissance")
public class BaseConnaissance {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int Id;
    private String titre;
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    Formateur formateur;


}
