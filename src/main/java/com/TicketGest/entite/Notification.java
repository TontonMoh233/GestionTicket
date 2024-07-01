package com.TicketGest.entite;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int idticket;
    private String message;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "notification_id")
    Notification notification;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    Formateur formateur;

    @ManyToOne
    @JoinColumn(name="apprenant_id")
    Apprenant apprenant;

}
