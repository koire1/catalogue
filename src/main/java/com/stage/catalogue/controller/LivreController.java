package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Langue;
import com.stage.catalogue.entity.Auteur;
import com.stage.catalogue.entity.Categorie;
import com.stage.catalogue.entity.Livre;
import com.stage.catalogue.service.LivreService;
import java.sql.Date;
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
@RequestMapping("${apiPrefix}/livres")

public class LivreController {

    @Autowired
    private LivreService livreService;
    
    @PostMapping
    public Livre addLivre(@RequestBody Livre liv){
        return livreService.addLivre(liv);
    }
    
    @GetMapping(value = "/{isbn}")
    public Livre getLivreByIsbn(@PathVariable("isbn") String isbn){
        return livreService.getLivreByIsbn(isbn);
    }
    
    @GetMapping(value = "/{titre}")
    public Page<Livre> getLivreByTitre(@PathVariable("titre") String titre, @RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "10") int size){
        return livreService.getLivreByTitre(titre, page, size);
    }
    
    @GetMapping(value = "/{cote}")
    public Livre getLivreByCote(@PathVariable("cote") String cote){
        return livreService.getLivreByCote(cote);
    }
    
    @GetMapping(value = "/{anneepub}")
    public Page<Livre> getLivreByAnneePub(@PathVariable("anneepub") Date anneepub, @RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "10") int size){
        return livreService.getLivreByAnneePub(anneepub, page, size);
    }
    
    @GetMapping(value = "/{maisonedit}")
    public Page<Livre> getLivreByMaisonEdit(@PathVariable("maisonedit") String maisonedit, @RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "10") int size){
        return livreService.getLivreByMaisonEdit(maisonedit, page, size);
    }
    
    @GetMapping(value = "/{titre}/{langue}")
    public Page<Livre> getLivreByTitreAndLangue(@PathVariable("titre") String titre, @PathVariable("langue") Langue langue, @RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "10") int size){
        return livreService.getLivreByTitreAndLangue(titre, langue, page, size);
    }
    
    @GetMapping(value = "/{langue}")
    public Page<Livre> getLivreByLangue(@PathVariable("langue") Langue langue, @RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "10") int size){
        return livreService.getLivreByLangue(langue, page, size);
    }
    
   @GetMapping(value = "/{id}/auteurs")
    public List<Auteur> getAuteurs(@PathVariable("id") Long id){
        return livreService.getAuteurs(id);
    }
    
    @GetMapping(value = "/{id}/categorie")
    public Categorie getCategorie(@PathVariable("id") Long id){
        return livreService.getCategorie(id);
    }
    
    @GetMapping
    public Page<Livre> getAllLivre(@RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "10") int size){
        return livreService.findAll(page, size);
    }
    
    @PutMapping(value = "/{id}")
    public Livre updateLivreById(Livre liv, @PathVariable("idLivre") Long idLivre){
        return livreService.editLivreById(liv);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropLivreById(@PathVariable("idLivre") Long idLivre){
        livreService.dropLivreById(idLivre);
    }
}
