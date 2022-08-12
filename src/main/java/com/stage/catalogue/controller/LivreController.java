package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Langue;
import com.stage.catalogue.entity.Livre;
import com.stage.catalogue.entity.Auteur;
import com.stage.catalogue.service.LivreService;
import java.sql.Date;
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
@RequestMapping("${apiPrefix}/livres")

public class LivreController {

    @Autowired
    private LivreService livreService;
    
    @PostMapping()
    public Livre addLivre(@RequestBody Livre liv){
        return livreService.addLivre(liv);
    }
    
    @GetMapping(value = "/{isbn}")
    public Livre getLivreByIsbn(@PathVariable("isbn") String isbn){
        return livreService.getLivreByIsbn(isbn);
    }
    
    @GetMapping(value = "/{titre}")
    public Page<Livre> getLivreByTitre(@PathVariable("titre") String titre, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livreService.getLivreByTitre(titre, page, size);
    }
    
    @GetMapping(value = "/{cote}")
    public Livre getLivreByCote(@PathVariable("cote") String cote){
        return livreService.getLivreByCote(cote);
    }
    
    @GetMapping(value = "/{anneepub}")
    public Page<Livre> getLivreByAnneePub(@PathVariable("anneepub") Date anneepub, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livreService.getLivreByAnneePub(anneepub, page, size);
    }
    
    @GetMapping(value = "/{maisonedit}")
    public Page<Livre> getLivreByMaisonEdit(@PathVariable("maisonedit") String maisonedit, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livreService.getLivreByMaisonEdit(maisonedit, page, size);
    }
    
    @GetMapping(value = "/{titre}/{langue}")
    public Page<Livre> getLivreByTitreAndLangue(@PathVariable("titre") String titre, @PathVariable("langue") Langue langue, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livreService.getLivreByTitreAndLangue(titre, langue, page, size);
    }
    
    @GetMapping(value = "/{langue}")
    public Page<Livre> getLivreByLangue(@PathVariable("langue") Langue langue, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livreService.getLivreByLangue(langue, page, size);
    }
    
    @GetMapping(value = "/{nomauteur}")
    public Page<Livre> getByNomAuteur(@PathVariable("nomAuteur") String nomAuteur, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livreService.getByNomAuteur(nomAuteur, page, size);
    }
    
    @GetMapping(value = "/{nomCategorie}")
    public Page<Livre> getByNomCategorie(@PathVariable("nomCategorie") String nomCategorie, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livreService.getByNomCategorie(nomCategorie, page, size);
    }
    
    @GetMapping()
    public Page<Livre> getAllLivre(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return livreService.findAll(page, size);
    }
    
    @PutMapping(value = "/{id}")
    public Livre updateLivreById(Livre liv, @PathVariable("idLivre") long idLivre){
        return livreService.editLivreById(liv);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropLivreById(@PathVariable("idLivre") long idLivre){
        livreService.dropLivreById(idLivre);
    }
}
