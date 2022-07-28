package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Langue;
import com.stage.catalogue.entity.Livre;
import com.stage.catalogue.service.LivreService;
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

public class LivreController {

    @Autowired
    private LivreService livre;
    
    @RequestMapping(value = "/ajoutLivre", method = RequestMethod.POST)
    public Livre addLivre(@RequestBody Livre liv){
        return livre.addLivre(liv);
    }
    
    @RequestMapping(value = "/listLivre/{isbn}", method = RequestMethod.GET)
    public Livre getLivreByIsbn(@PathParam("isbn") String isbn){
        return livre.getLivreByIsbn(isbn);
    }
    
    @RequestMapping(value = "/listLivre/{titre}", method = RequestMethod.GET)
    public List<Livre> getLivreByTitre(@PathParam("titre") String titre){
        return livre.getLivreByTitre(titre);
    }
    
    @RequestMapping(value = "/listLivre/{cote}", method = RequestMethod.GET)
    public Livre getLivreByCote(@PathParam("cote") String cote){
        return livre.getLivreByCote(cote);
    }
    
    @RequestMapping(value = "/listLivre/{anneepub}", method = RequestMethod.GET)
    public List<Livre> getLivreByAnneePub(@PathParam("anneepub") String anneepub){
        return livre.getLivreByAnneePub(anneepub);
    }
    
    @RequestMapping(value = "/listLivre/{maisonedit}", method = RequestMethod.GET)
    public List<Livre> getLivreByMaisonEdit(@PathParam("maisonedit") String maisonedit){
        return livre.getLivreByMaisonEdit(maisonedit);
    }
    
    @RequestMapping(value = "/listLivre", method = RequestMethod.GET)
    public List<Livre> getLivreByTitreAndLangue(@PathParam("titre") String titre, @PathParam("langue") Langue langue){
        return livre.getLivreByTitreAndLangue(titre, langue);
    }
    
    @RequestMapping(value = "/modifLivre", method = RequestMethod.GET)
    public Livre updateLivre(@RequestBody Livre liv){
        return livre.editLivre(liv);
    }
}
