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
        name = "apprenant"
)
public class Apprenant extends Utilisateur{


    @OneToMany(mappedBy = "apprenant")
    List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name="formateur_id")
    Formateur formateur;

    @OneToMany (mappedBy = "apprenant")
    List<Notification> notification;

}
