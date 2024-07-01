package com.TicketGest.Controller;

import com.TicketGest.Service.AdminService;
import com.TicketGest.Service.BaseService;
import com.TicketGest.Service.FormateurService;
import com.TicketGest.Service.RoleService;
import com.TicketGest.entite.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;
    private FormateurService formateurService;
    private BaseService baseService;
    private RoleService roleService;

    //Admin
    //Create Admin
    @PostMapping("/createAdmin")
    public Admin creation(@RequestBody Admin admin) {
        return this.adminService.createAdmin(admin);
    }
    //Liste Admin
    @GetMapping("{id}")
    public List<Admin> allAdmin(){
        return adminService.allAdmin();
    }

    //Ajouter formateur
    @PostMapping("/formateur/create")
    public Formateur creation(@RequestBody Formateur formateur) {
        return this.formateurService.creeformateur(formateur);

    }
//SUPPRIMER FORMATEUR
    @DeleteMapping(path = "/formateur/delete/{id}")
    public void SupprimerFormateur(@PathVariable Long id) {
        this.formateurService.SuppFormateur(id);

    }

    // LIRE UN FORMATEUR

    @GetMapping(path = "/formateur/{id}")
    public Formateur Lire(@PathVariable Long id) {
        return this.formateurService.lire(id);

    }

    // Afficher tous les formateus

    @GetMapping(path = "/formateur/all")

    public List<Formateur> AfficherFormateur(Formateur formateur){
        return this.formateurService.affiche(formateur);
    }


// AJOUTER DANS LA BASE DES CONNAISSANCES

    @PostMapping(path = "/base/create")

    public BaseConnaissance ajout(@RequestBody BaseConnaissance baseConnaissance){

        return this.baseService.sauver(baseConnaissance);
    }

    //roles

    // Ajout Roles
    @PostMapping("/role/create")

    public Role ajouterRole(@RequestBody Role role){
        return roleService.ajouterRole(role);
    }

    //lister role

    @GetMapping(path = "/role/all")

    public List<Role> allRole(){
        return roleService.allRole();
    }

    // lire un seul role

    @GetMapping(path = "/role/{id}")

    public Optional<Role> lire(@PathVariable int id){
        return roleService.getId(id);
    }

    // supprimer role

    @DeleteMapping(path = "role/delete/{id}")
    public void delleteRole(@PathVariable int id){
        roleService.deletteRole(id);
    }
    //


    // modification d'un formateur

    @PutMapping("/formateur/modiff/{id}")

    public Formateur uppdaty(@PathVariable Long id , @RequestBody Formateur formateur){
        return formateurService.miseJour(id,formateur);
    }

}
