package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Auteur;
import com.stage.catalogue.entity.Livre;
import com.stage.catalogue.service.AuteurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    private AuteurService auteurService;
    
    @PostMapping
    public Auteur addAuteur(@RequestBody Auteur aut){
        return auteurService.addAuteur(aut);
    }
    
    @GetMapping(value = "/{id}")
    public Auteur getAuteurById(@PathVariable("id") Long idAuteur){
        return auteurService.getAuteurById(idAuteur);
    }
    
    @GetMapping(value = "/{nomauteur}")
    public Page<Auteur> getAuteurByNom(@PathVariable("nomauteur") String nomAuteur, @RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "0") int size){
        return auteurService.getAuteurByNom(nomAuteur, page, size);
    }
    
    @GetMapping
    public List<Auteur> getAllAuteur(){
        return auteurService.getAll();
    }
    
    @PutMapping(value = "/{id}")
    public Auteur updateAuteur(Auteur aut, @PathVariable("id") Long idAuteur){
        return auteurService.editAuteur(aut);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropAuteur(@PathVariable("id") Long idAuteur){
        auteurService.dropAuteurById(idAuteur);
    }
    
    @GetMapping(value = "/{nomauteur}/livres")
    public List<Livre> getLivres(@PathVariable("nomauteur") String nomAuteur){
        return auteurService.getLivres(nomAuteur);
    }
}
