package com.stage.catalogue.service;

import com.stage.catalogue.dao.CategorieDao;
import com.stage.catalogue.entity.Categorie;
import com.stage.catalogue.entity.Livre;
import java.util.List;
import java.util.Optional;
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
    private CategorieDao categorieDao;

    public Categorie addCategorie(Categorie categorie) {
        return categorieDao.save(categorie);
    }

    public Page<Categorie> getCategorieByNom(String nomCategorie, int page, int size) {
        return categorieDao.findByNomLike(nomCategorie, PageRequest.of(page, size));
    }

    public Categorie getCategorieById(Long idCategorie) {
        return categorieDao.findById(idCategorie).orElse(null);
    }

    public List<Categorie> getAll() {
        return categorieDao.findAll();
    }

    public Categorie editCategorieById(Categorie categorie) {
        Optional<Categorie> oCategorie = categorieDao.findById(categorie.getId());
        if (oCategorie.isPresent()) {
            Categorie existingCategorie = oCategorie.get();
            existingCategorie.setNom(categorie.getNom());
            return categorieDao.save(existingCategorie);
        }
        return null;
    }

    public void dropCategorieById(Long idCategorie) {
        categorieDao.deleteById(idCategorie);
    }
    
    public List<Livre> getLivres(String nomCategorie){
        Optional<Categorie> oCategorie = categorieDao.findByNom(nomCategorie);
        
        if(oCategorie.isPresent()){
            return oCategorie.get().getLivres();
        }else{
            return null;
        }
    }
}
