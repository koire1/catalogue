package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Categorie;
import com.stage.catalogue.service.CategorieService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/categorie")

public class CategorieController {
    
    @Autowired
    private CategorieService categorie;
    
    @PostMapping()
    public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie cat){
        return categorie.addCategorie(cat);
    }
    
    @GetMapping(value = "{id: \\id+}")
    public ResponseEntity<Categorie> getCategorieById(@PathParam("idCategorie") int idCategorie){
        return categorie.getCategorieById(idCategorie);
    }
    
    @GetMapping()
    public Page<Categorie> getCategorieByNom(@PathParam("nomCategorie") String nomCategorie, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return categorie.getCategorieByNom(nomCategorie, page, size);
    }
    
    @GetMapping(value = "/all")
    public List<Categorie> getAllCategorie(){
        return categorie.getAllCategorie();
    }
    
    @PutMapping("/edit")
    public ResponseEntity<Categorie> updateCategorie(Categorie cat, @PathParam("idCategorie") int idCategorie){
        return categorie.editCategorieById(cat, idCategorie);
    }
    
    @DeleteMapping(value = "/delete/{id: \\id+}")
    public void dropCategorie(int idCategorie){
        categorie.dropCategorieById(idCategorie);
    }
}
