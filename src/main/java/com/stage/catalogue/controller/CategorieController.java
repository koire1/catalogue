package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Categorie;
import com.stage.catalogue.service.CategorieService;
import com.stage.catalogue.entity.Livre;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author cellule
 */
@RestController
@RequestMapping("${apiPrefix}/categories")

public class CategorieController {
    
    @Autowired
    private CategorieService categorieService;
    
    @PostMapping
    public Categorie addCategorie(@RequestBody Categorie cat){
        return categorieService.addCategorie(cat);
    }
    
    @GetMapping(value = "/{id}")
    public Categorie getCategorieById(@PathVariable("id") Long idCategorie){
        return categorieService.getCategorieById(idCategorie);
    }
    
    @GetMapping(value = "/{nomcategorie}")
    public Page<Categorie> getCategorieByNom(@PathVariable("nomcategorie") String nomCategorie, @RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "0") int size){
        return categorieService.getCategorieByNom(nomCategorie, page, size);
    }
    
    @GetMapping
    public List<Categorie> getAll(){
        return categorieService.getAll();
    }
    
    @PutMapping("/{id}")
    public Categorie updateCategorie(Categorie cat, @PathVariable("id") Long idCategorie){
        return categorieService.editCategorieById(cat);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropCategorie(@PathVariable("id") Long idCategorie){
        categorieService.dropCategorieById(idCategorie);
    }
    
    @GetMapping(value = "/{nomcategorie}/livres")
    public List<Livre> getLivres(@PathVariable("nomcategorie") String nomCategorie){
        return categorieService.getLivres(nomCategorie);
    }
}
