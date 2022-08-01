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
    
    public Auteur getAuteurByIdAuteur(int idAuteur){
        return auteur.findAuteurByIdAuteur(idAuteur);
    }
    
    public List<Auteur> getAuteur(){
        return auteur.findAll();
    }
    public Auteur editAuteur(Auteur aut, int idAuteur){
        Auteur existingAuteur=auteur.findById(idAuteur).orElse(null);
               existingAuteur.setNomAuteur(aut.getNomAuteur());
        return auteur.save(existingAuteur);
    }
    public void dropAuteurById(int idAuteur){
        auteur.deleteById(idAuteur);
    }
}
