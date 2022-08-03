package com.stage.catalogue.service;

import com.stage.catalogue.dao.AuteurDao;
import com.stage.catalogue.entity.Auteur;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    
    public Auteur getAuteurById(int idAuteur){
            return auteur.findAuteurByIdAuteur(idAuteur);    
    }
    
    public List<Auteur> getAll(){
        return auteur.findAll();
    }
    
    public Page<Auteur> getAuteurByNom(String nomAuteur, int page, int size){
        return auteur.findAuteurByNomAuteur(nomAuteur, PageRequest.of(page, size));
    }
    
    public Auteur editAuteur(Auteur aut, int idAuteur){
        Auteur existingAuteur = auteur.findAuteurByIdAuteur(idAuteur);
               existingAuteur.setNomAuteur(aut.getNomAuteur());
        return auteur.save(existingAuteur);
        
    }
    
    public void dropAuteurById(int idAuteur){
        auteur.deleteById(idAuteur);
    }
}
