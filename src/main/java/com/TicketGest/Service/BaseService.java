package com.TicketGest.Service;

import com.TicketGest.Repositorie.BaseRepository;
import com.TicketGest.entite.BaseConnaissance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {
    @Autowired
    private BaseRepository baseRepository;

    // AJOUT D'UN ARTICLE
    public BaseConnaissance creerArticle(BaseConnaissance baseconnaissance) {
        return baseRepository.save(baseconnaissance);
    }

    public String deletearticle(Integer id){

        baseRepository.deleteById(id);
        return "Utilisateur Supprimer";
    }

    public BaseConnaissance sauver(BaseConnaissance baseConnaissance) {
        return this.baseRepository.save(baseConnaissance);
    }


}
