package com.TicketGest.entite;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name ="utilisateur")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String mot_de_passe;
    private String email;
    private boolean actif=true; // pour savoir si le compte de l'utilisateur est actif ou non
    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Role role;

    //@OneToOne
    //private List<Role> roles;


}
