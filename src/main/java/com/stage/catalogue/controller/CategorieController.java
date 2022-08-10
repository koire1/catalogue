package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Categorie;
import com.stage.catalogue.service.CategorieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Categorie getCategorieById(@PathVariable("id") long idCategorie){
        return categorieService.getCategorieById(idCategorie);
    }
    
    // TODO revision needed here
    /*@GetMapping
    public Page<Categorie> getCategorieByNom(@PathParam("nomcategorie") String nomCategorie, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return categorieService.getCategorieByNom(nomCategorie, page, size);
    }*/
    
    @GetMapping
    public List<Categorie> getAll(){
        return categorieService.getAll();
    }
    
    @PutMapping("/{id}")
    public Categorie updateCategorie(Categorie cat, @PathVariable("id") long idCategorie){
        return categorieService.editCategorieById(cat);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropCategorie(@PathVariable("id") long idCategorie){
        categorieService.dropCategorieById(idCategorie);
    }
}
