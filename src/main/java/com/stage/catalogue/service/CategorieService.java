package com.stage.catalogue.service;

import com.stage.catalogue.dao.CategorieDao;
import com.stage.catalogue.entity.Categorie;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/**
 *
 * @author cellule
 */
@Service
public class CategorieService {
    @Autowired
    private CategorieDao categorie;
    
    public ResponseEntity<Categorie> addCategorie(Categorie cat){
            Categorie c = categorie.save(cat);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(c.getIdCategorie())
                .toUri();
        return ResponseEntity.created(location).body(c);    }
    
    public Page<Categorie> getCategorieByNom(String nomCategorie, int page, int size){
        return categorie.findCategorieByNomCategorie(nomCategorie, PageRequest.of(page, size));
    }
    
    public ResponseEntity<Categorie> getCategorieById(int idCategorie){
            Optional<Categorie> cat = categorie.findCategorieByIdCategorie(idCategorie);
            if (cat.isPresent()) {
            return ResponseEntity.ok(cat.get());
            }
        return ResponseEntity.notFound().build();    
    }
    
    public List<Categorie> getAllCategorie(){
        return categorie.findAll();
    }
    
    public ResponseEntity<Categorie> editCategorieById(Categorie cat, int idCategorie){
        return categorie.findById(idCategorie).map(
                c -> {
                    c.setNomCategorie(cat.getNomCategorie());
                    return ResponseEntity.ok(categorie.save(c));
                }
                                     ).orElse(
                ResponseEntity.notFound().build()
        );
    }
    
    public void dropCategorieById(int idCategorie){
        categorie.deleteById(idCategorie);
    }
}
