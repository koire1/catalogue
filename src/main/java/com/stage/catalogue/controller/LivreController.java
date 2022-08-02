package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Langue;
import com.stage.catalogue.entity.Livre;
import com.stage.catalogue.service.LivreService;
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
@RequestMapping("/livres")

public class LivreController {

    @Autowired
    private LivreService livre;
    
    @PostMapping()
    public ResponseEntity<Livre> addLivre(@RequestBody Livre liv){
        return livre.addLivre(liv);
    }
    
    @GetMapping()
    public ResponseEntity<Livre> getLivreByIsbn(@PathParam("isbn") String isbn){
        return livre.getLivreByIsbn(isbn);
    }
    
    @GetMapping()
    public Page<Livre> getLivreByTitre(@PathParam("titre") String titre, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livre.getLivreByTitre(titre, page, size);
    }
    
    @GetMapping()
    public ResponseEntity<Livre> getLivreByCote(@PathParam("cote") String cote){
        return livre.getLivreByCote(cote);
    }
    
    @GetMapping()
    public Page<Livre> getLivreByAnneePub(@PathParam("anneepub") String anneepub, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livre.getLivreByAnneePub(anneepub, page, size);
    }
    
    @GetMapping()
    public Page<Livre> getLivreByMaisonEdit(@PathParam("maisonedit") String maisonedit, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livre.getLivreByMaisonEdit(maisonedit, page, size);
    }
    
    @GetMapping()
    public Page<Livre> getLivreByTitreAndLangue(@PathParam("titre") String titre, @PathParam("langue") Langue langue, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livre.getLivreByTitreAndLangue(titre, langue, page, size);
    }
    
    @GetMapping()
    public Page<Livre> getLivreByLangue(@PathParam("langue") Langue langue, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livre.getLivreByLangue(langue, page, size);
    }
    
    @GetMapping(value = "/all")
    public Page<Livre> getAllLivre(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livre.findAll(page, size);
    }
    
    @PutMapping(value = "/edit")
    public ResponseEntity<Livre> updateLivreById(Livre liv, @PathParam("idLivre") int idLivre){
        return livre.editLivreById(liv, idLivre);
    }
    
    @DeleteMapping(value = "/delete/{id: \\id+}")
    public void dropLivreById(@PathParam("idLivre") int idLivre){
        livre.dropLivreById(idLivre);
    }
}
