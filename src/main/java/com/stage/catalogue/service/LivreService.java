package com.stage.catalogue.service;

import com.stage.catalogue.dao.LivreDao;
import com.stage.catalogue.entity.Langue;
import com.stage.catalogue.entity.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    
    public Page<Livre> getLivreByTitre(String titre, Pageable pageable){
        return livre.findLivreByTitre(titre, pageable);
    }
    
    public Livre getLivreByCote(String cote){
        return livre.findLivreByCote(cote);
    }
    
    public Page<Livre> getLivreByAnneePub(String anneepub, Pageable pageable){
        return livre.findLivreByAnneePub(anneepub, pageable);
    }
    
    public Page<Livre> getLivreByMaisonEdit(String maisonEdit, Pageable pageable){
        return livre.findLivreByMaisonEdit(maisonEdit, pageable);
    }
    
    public Page<Livre> getLivreByTitreAndLangue(String titre, Langue langue, Pageable pageable){
        return livre.findLivreByTitreAndLangue(titre, langue, pageable);
    }
    
    public Page<Livre> getLivreByIdAuteur(AuteurService auteur, int idAuteur){
        return livre.findLivreByIdAuteur(auteur, idAuteur);
    }
    
    public Page<Livre> findAll(Pageable pageable){
        return livre.findAll(pageable);
    }
    
    public Livre editLivreById(Livre liv, int idLivre){
        Livre existingLivre=livre.findById(idLivre).orElse(null);
              existingLivre.setAnneePub(liv.getAnneePub());
              existingLivre.setCote(liv.getCote());
              existingLivre.setIsbn(liv.getIsbn());
              existingLivre.setLangue(liv.getLangue());
              existingLivre.setTitre(liv.getTitre());
              existingLivre.setMaisonEdit(liv.getMaisonEdit());
              existingLivre.setImage(liv.getImage());
              existingLivre.setNbrePage(liv.getNbrePage());
        return livre.save(existingLivre);
    }
    
    public void dropLivreById(int idLivre){
        livre.deleteById(idLivre);
    }
}