package com.stage.catalogue.service;

import com.stage.catalogue.dao.CategorieDao;
import com.stage.catalogue.entity.Categorie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author cellule
 */
@Service
public class CategorieService {
    @Autowired
    private CategorieDao categorie;
    
    public Categorie addCategorie(Categorie cat){
        return categorie.save(cat);
    }
    
    public List<Categorie> getCategorie(String nomCategorie){
        return categorie.findCategorieByNomCategorie(nomCategorie);
    }
    
    public Categorie editCategorie(Categorie cat){
        Categorie existingCategorie=categorie.findById(cat.getIdCategorie()).orElse(null);
                  existingCategorie.setNomCategorie(cat.getNomCategorie());
        return categorie.save(existingCategorie);
    }
}
