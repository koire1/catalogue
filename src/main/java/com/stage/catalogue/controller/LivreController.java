package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Langue;
import com.stage.catalogue.entity.Livre;
import com.stage.catalogue.service.LivreService;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Livre addLivre(@RequestBody Livre liv){
        return livre.addLivre(liv);
    }
    
    @GetMapping(value = "/{isbn}")
    public Livre getLivreByIsbn(@PathParam("isbn") String isbn){
        return livre.getLivreByIsbn(isbn);
    }
    
    @GetMapping(value = "/{titre}")
    public Page<Livre> getLivreByTitre(@PathParam("titre") String titre, @RequestParam("page") int page, @RequestParam("size") int size){
        Pageable pageable = PageRequest.of(page, size);
        return livre.getLivreByTitre(titre, pageable);
    }
    
    @GetMapping(value = "/{cote}")
    public Livre getLivreByCote(@PathParam("cote") String cote){
        return livre.getLivreByCote(cote);
    }
    
    @GetMapping(value = "/{anneepub}")
    public Page<Livre> getLivreByAnneePub(@PathParam("anneepub") String anneepub, @RequestParam("page") int page, @RequestParam("size") int size){
        Pageable pageable = PageRequest.of(page, size);
        return livre.getLivreByAnneePub(anneepub, pageable);
    }
    
    @GetMapping(value = "/{maisonedit}")
    public Page<Livre> getLivreByMaisonEdit(@PathParam("maisonedit") String maisonedit, @RequestParam("page") int page, @RequestParam("size") int size){
        Pageable pageable = PageRequest.of(page, size);
        return livre.getLivreByMaisonEdit(maisonedit, pageable);
    }
    
    @GetMapping(value = "/{titre}&&{langue}")
    public Page<Livre> getLivreByTitreAndLangue(@PathParam("titre") String titre, @PathParam("langue") Langue langue, @RequestParam("page") int page, @RequestParam("size") int size){
        Pageable pageable = PageRequest.of(page, size);
        return livre.getLivreByTitreAndLangue(titre, langue, pageable);
    }
    
    @GetMapping(value = "/{langue}")
    public Page<Livre> getLivreByLangue(@PathParam("langue") Langue langue, @RequestParam("page") int page, @RequestParam("size") int size){
        Pageable pageable = PageRequest.of(page, size);
        return livre.getLivreByTitreAndLangue(langue, pageable);
    }
    
    @GetMapping(value = "/all")
    public Page<Livre> getAllLivre(@RequestParam("page") int page, @RequestParam("size") int size){
        Pageable pageable = PageRequest.of(page, size);
        return livre.findAll(pageable);
    }
    
    @PutMapping(value = "/edit/{id}")
    public Livre updateLivreById(@RequestBody Livre liv, @PathParam("idLivre") int idLivre){
        return livre.editLivreById(liv, idLivre);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public void dropLivreById(@PathParam("idLivre") int idLivre){
        livre.dropLivreById(idLivre);
    }
}
