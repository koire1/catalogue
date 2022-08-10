package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Auteur;
import com.stage.catalogue.service.AuteurService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
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
@RequestMapping("${apiPrefix}/auteurs")

public class AuteurController {
    
    @Autowired
    private AuteurService auteur;
    
    @PostMapping
    public Auteur addAuteur(@RequestBody Auteur aut){
        return auteur.addAuteur(aut);
    }
    
    @GetMapping(value = "/{id}")
    public Auteur getAuteurById(@PathVariable("id") long idAuteur){
        return auteur.getAuteurById(idAuteur);
    }
    
    // TODO ce mapping n'est pas correct
    @GetMapping
    public Page<Auteur> getAuteurByNom(@PathParam("nomauteur") String nomAuteur, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return auteur.getAuteurByNom(nomAuteur, page, size);
    }
    
    @GetMapping
    public List<Auteur> getAllAuteur(){
        return auteur.getAll();
    }
    
    @PutMapping(value = "/{id}")
    public Auteur updateAuteur(Auteur aut, @PathVariable("id") long idAuteur){
        return auteur.editAuteur(aut);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropAuteur(@PathVariable("id") long idAuteur){
        auteur.dropAuteurById(idAuteur);
    }
}
