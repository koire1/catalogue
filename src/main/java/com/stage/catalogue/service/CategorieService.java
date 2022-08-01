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
    
    public Categorie getCategorieByNom(String nomCategorie){
        return categorie.findCategorieByNomCategorie(nomCategorie);
    }
    
    public List<Categorie> getAllCategorie(){
        return categorie.findAll();
    }
    
    public Categorie editCategorieById(Categorie cat, int idCategorie){
        Categorie existingCategorie=categorie.findById(idCategorie).orElse(null);
                  existingCategorie.setNomCategorie(cat.getNomCategorie());
        return categorie.save(existingCategorie);
    }
    
    public void dropCategorieById(int idCategorie){
        categorie.deleteById(idCategorie);
    }
}
