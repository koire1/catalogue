package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Langue;
import com.stage.catalogue.entity.Livre;
import com.stage.catalogue.service.LivreService;
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
@RequestMapping("/livres")

public class LivreController {

    @Autowired
    private LivreService livre;
    
    @PostMapping()
    public Livre addLivre(@RequestBody Livre liv){
        return livre.addLivre(liv);
    }
    
    @GetMapping(value = "/search/isbn/{isbn}")
    public Livre getLivreByIsbn(@PathVariable("isbn") String isbn){
        return livre.getLivreByIsbn(isbn);
    }
    
    @GetMapping(value = "/search/titre/{titre}")
    public Page<Livre> getLivreByTitre(@PathVariable("titre") String titre, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livre.getLivreByTitre(titre, page, size);
    }
    
    @GetMapping(value = "/search/cote")
    public Livre getLivreByCote(@PathParam("cote") String cote){
        return livre.getLivreByCote(cote);
    }
    
    @GetMapping(value = "/searh/anneePub")
    public Page<Livre> getLivreByAnneePub(@PathParam("anneepub") String anneepub, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livre.getLivreByAnneePub(anneepub, page, size);
    }
    
    @GetMapping(value = "/search/maisonEdit")
    public Page<Livre> getLivreByMaisonEdit(@PathParam("maisonedit") String maisonedit, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livre.getLivreByMaisonEdit(maisonedit, page, size);
    }
    
    @GetMapping(value = "/search/titreEtlangue")
    public Page<Livre> getLivreByTitreAndLangue(@PathParam("titre") String titre, @PathParam("langue") Langue langue, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livre.getLivreByTitreAndLangue(titre, langue, page, size);
    }
    
    @GetMapping(value = "/search/langue")
    public Page<Livre> getLivreByLangue(@PathParam("langue") Langue langue, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livre.getLivreByLangue(langue, page, size);
    }
    
    @GetMapping(value = "/all")
    public Page<Livre> getAllLivre(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livre.findAll(page, size);
    }
    
    @PutMapping(value = "/edit/{id}")
    public Livre updateLivreById(Livre liv, @PathVariable("idLivre") int idLivre){
        return livre.editLivreById(liv, idLivre);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public void dropLivreById(@PathVariable("idLivre") int idLivre){
        livre.dropLivreById(idLivre);
    }
}
