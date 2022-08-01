package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Categorie;
import com.stage.catalogue.service.CategorieService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/categorie")

public class CategorieController {
    
    @Autowired
    private CategorieService categorie;
    
    @PostMapping()
    public Categorie addCategorie(@RequestBody Categorie cat){
        return categorie.addCategorie(cat);
    }
    
    @GetMapping(value = "/id")
    public Categorie getCategorieById(@PathParam("idCategorie") int idCategorie){
        return categorie.getCategorieById(idCategorie);
    }
    
    @GetMapping(value = "/nomCategorie")
    public Categorie getCategorieByNom(@PathParam("nomCategorie") String nomCategorie){
        return categorie.getCategorieByNom(nomCategorie);
    }
    
    @GetMapping(value = "/all")
    public List<Categorie> getAllCategorie(){
        return categorie.getAllCategorie();
    }
    
    @PutMapping(value = "/edit")
    public Categorie updateCategorie(@RequestBody Categorie cat, int idCategorie){
        return categorie.editCategorieById(cat, idCategorie);
    }
    
    @DeleteMapping(value = "/delete")
    public void dropCategorie(int idCategorie){
        categorie.dropCategorieById(idCategorie);
    }
}
