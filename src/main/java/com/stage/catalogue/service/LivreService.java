package com.stage.catalogue.service;

import com.stage.catalogue.dao.LivreDao;
import com.stage.catalogue.entity.Langue;
import com.stage.catalogue.entity.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
/**
 *
 * @author cellule
 */
@Service
public class LivreService {
    @Autowired
    private LivreDao livre;
   
    public Livre addLivre(Livre liv){
        return livre.save(liv);
    }
    
    public Livre getLivreByIsbn(String isbn){
        return livre.findLivreByIsbn(isbn);
    }
    
    public Page<Livre> getLivreByTitre(String titre, int page, int size){
        return livre.findLivreByTitre(titre, PageRequest.of(page, size));
    }
    
    public Livre getLivreByCote(String cote){
        return livre.findLivreByCote(cote);
    }
    
    public Page<Livre> getLivreByAnneePub(String anneepub, int page, int size){
        return livre.findLivreByAnneePub(anneepub, PageRequest.of(page, size));
    }
    
    public Page<Livre> getLivreByMaisonEdit(String maisonEdit, int page, int size){
        return livre.findLivreByMaisonEdit(maisonEdit, PageRequest.of(page, size));
    }
    
    public Page<Livre> getLivreByTitreAndLangue(String titre, Langue langue, int page, int size){
        return livre.findLivreByTitreAndLangue(titre, langue, PageRequest.of(page, size));
    }
    
    public Page<Livre> getLivreByLangue(Langue langue, int page, int size){
        return livre.findLivreByLangue(langue, PageRequest.of(page, size));
    }
    
    public Page<Livre> findAll(int page, int size){
        return livre.findAll(PageRequest.of(page, size));
    }
    
    public Livre editLivreById(Livre liv, int idLivre){
        Livre existingLivre = livre.findLivreByIdLivre(idLivre);
              existingLivre.setAnneePub(liv.getAnneePub());
              existingLivre.setAuteur(liv.getAuteur());
              existingLivre.setCategorie(liv.getCategorie());
              existingLivre.setCote(liv.getCote());
              existingLivre.setIsbn(liv.getIsbn());
              existingLivre.setLangue(liv.getLangue());
              existingLivre.setMaisonEdit(liv.getMaisonEdit());
              existingLivre.setNbrePage(liv.getNbrePage());
              existingLivre.setNbreVueLivre(liv.getNbreVueLivre());
              existingLivre.setTitre(liv.getTitre());
              existingLivre.setImage(liv.getImage());
        return livre.save(existingLivre);
    }
    
    public void dropLivreById(int idLivre){
        livre.deleteById(idLivre);
    }
}