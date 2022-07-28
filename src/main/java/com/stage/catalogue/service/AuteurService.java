package com.stage.catalogue.service;

import com.stage.catalogue.dao.AuteurDao;
import com.stage.catalogue.entity.Auteur;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cellule
 */
@Service
public class AuteurService {
    @Autowired
    private AuteurDao auteur;
    
    public Auteur addAuteur(Auteur aut){
        return auteur.save(aut);
    }
    
    public List<Auteur> getAuteur(String nomAuteur){
        return auteur.findAuteurByNomAuteur(nomAuteur);
    }
    
    public Auteur editAuteur(Auteur aut){
        Auteur existingAuteur=auteur.findById(aut.getIdAuteur()).orElse(null);
               existingAuteur.setNomAuteur(aut.getNomAuteur());
        return auteur.save(existingAuteur);
    }
    
    
}
