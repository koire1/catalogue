package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Auteur;
import com.stage.catalogue.service.AuteurService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author cellule
 */
@RestController
@RequestMapping("/auteurs")

public class AuteurController {
    
    @Autowired
    private AuteurService auteur;
    
    @PostMapping()
    public Auteur addAuteur(@RequestBody Auteur aut){
        return auteur.addAuteur(aut);
    }
    
    @GetMapping(value = "/{id}")
    public Auteur getAuteurById(@PathParam("idAuteur") int idAuteur){
        return auteur.getAuteurById(idAuteur);
    }
    
    @GetMapping(value = "/{nomauteur}")
    public Auteur getAuteurByNom(@PathParam("nomAuteur") String nomAuteur){
        return auteur.getAuteurByNom(nomAuteur);
    }
    
    @GetMapping(value = "/all")
    public List<Auteur> getAllAuteur(){
        return auteur.getAuteur();
    }
    
    @GetMapping(value = "/edit/{id}")
    public Auteur updateAuteur(@RequestBody Auteur aut, @PathParam("idAuteur") int idAuteur){
        return auteur.editAuteur(aut, idAuteur);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public void dropAuteur(@PathParam("idAuteur") int idAuteur){
        auteur.dropAuteurById(idAuteur);
    }
}
