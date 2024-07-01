package com.TicketGest.Service;

import com.TicketGest.Repositorie.AdminRepository;
import com.TicketGest.Repositorie.FormateurRepository;
import com.TicketGest.Repositorie.RoleRepository;
import com.TicketGest.entite.Admin;
import com.TicketGest.entite.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    private FormateurRepository formateurRepository;
    @Autowired
    private RoleRepository roleRepository;

    public Admin createAdmin(Admin admin){
        Role role = roleRepository.findByName("Admin");
        admin.setRole(role);
        return this.adminRepository.save(admin);
    }
    public List<Admin> allAdmin(){
        return adminRepository.findAll();
    }
    // GetbyId Admin
    public Optional<Admin> adminById(Long id){
        return adminRepository.findById(id);
    }


}
