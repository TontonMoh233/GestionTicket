package com.TicketGest.Service;

import com.TicketGest.Repositorie.RoleRepository;
import com.TicketGest.entite.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role ajouterRole(Role role){
        return roleRepository.save(role);
    }

    public List<Role> allRole(){
    return roleRepository.findAll();

    }

    public Optional<Role> getId(int id){
        return roleRepository.findById(id);
    }

    public void deletteRole(int id){
        this.roleRepository.deleteById(id);
    }
}
