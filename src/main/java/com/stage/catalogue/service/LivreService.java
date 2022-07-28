package com.stage.catalogue.service;

import com.stage.catalogue.dao.LivreDao;
import com.stage.catalogue.entity.Langue;
import com.stage.catalogue.entity.Livre;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    public List<Livre> getLivreByTitre(String titre){
        return livre.findLivreByTitre(titre);
    }
    
    public Livre getLivreByCote(String cote){
        return livre.findLivreByCote(cote);
    }
    
    public List<Livre> getLivreByAnneePub(String anneepub){
        return livre.findLivreByAnneePub(anneepub);
    }
    
    public List<Livre> getLivreByMaisonEdit(String maisonEdit){
        return livre.findLivreByMaisonEdit(maisonEdit);
    }
    
    public List<Livre> getLivreByTitreAndLangue(String titre, Langue langue){
        return livre.findLivreByTitreAndLangue(titre, langue);
    }
    
    public Livre editLivre(Livre liv){
        Livre existingLivre=livre.findById(liv.getIdLivre()).orElse(null);
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
}
