package com.stage.catalogue.service;

import com.stage.catalogue.dao.CategorieDao;
import com.stage.catalogue.entity.Categorie;
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
public class CategorieService {
    @Autowired
    private CategorieDao categorie;
    
    public Categorie addCategorie(Categorie cat){
           return categorie.save(cat);    
    }
    
    public Page<Categorie> getCategorieByNom(String nomCategorie, int page, int size){
        return categorie.findCategorieByNomCategorie(nomCategorie, PageRequest.of(page, size));
    }
    
    public Categorie getCategorieById(int idCategorie){
            return categorie.findCategorieByIdCategorie(idCategorie);
    }
    
    public List<Categorie> getAll(){
        return categorie.findAll();
    }
    
    public Categorie editCategorieById(Categorie cat, int idCategorie){
        Categorie existingCategorie = categorie.findCategorieByIdCategorie(idCategorie);
                  existingCategorie.setNomCategorie(cat.getNomCategorie());
        return categorie.save(existingCategorie);
    }
    
    public void dropCategorieById(int idCategorie){
        categorie.deleteById(idCategorie);
    }
}
