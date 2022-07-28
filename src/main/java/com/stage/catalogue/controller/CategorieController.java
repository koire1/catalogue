package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Categorie;
import com.stage.catalogue.service.CategorieService;
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
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/app")

public class CategorieController {
    
    @Autowired
    private CategorieService categorie;
    
    @RequestMapping(value = "/ajoutCategorie", method = RequestMethod.POST)
    public Categorie addCategorie(@RequestBody Categorie cat){
        return categorie.addCategorie(cat);
    }
    
    @RequestMapping(value = "/listCategorie/{nomCategorie}", method = RequestMethod.GET)
    public List<Categorie> getCategorie(@PathParam("nomCategorie") String nomCategorie){
        return categorie.getCategorie(nomCategorie);
    }
    
    @RequestMapping(value = "/modifCategorie", method = RequestMethod.GET)
    public Categorie updateCategorie(@RequestBody Categorie cat){
        return categorie.editCategorie(cat);
    }
}
