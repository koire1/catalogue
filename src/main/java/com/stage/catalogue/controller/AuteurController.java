package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Auteur;
import com.stage.catalogue.service.AuteurService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author cellule
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/app")

public class AuteurController {
    
    @Autowired
    private AuteurService auteur;
    
    @RequestMapping(value = "/AjoutAuteur", method = RequestMethod.POST)
    public Auteur addAuteur(@RequestBody Auteur aut){
        return auteur.addAuteur(aut);
    }
    
    @RequestMapping(value = "/listAuteur/{nomAuteur}", method = RequestMethod.GET)
    public List<Auteur> getAuteurByNomAuteur(@PathParam("nomAuteur") String nomAuteur){
        return auteur.getAuteur(nomAuteur);
    }
    
    @RequestMapping(value = "/modifAuteur", method = RequestMethod.GET)
    public Auteur updateAuteur(@RequestBody Auteur aut){
        return auteur.editAuteur(aut);
    }
}
