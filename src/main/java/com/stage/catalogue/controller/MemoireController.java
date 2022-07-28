package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Cycle;
import com.stage.catalogue.entity.Memoire;
import com.stage.catalogue.service.MemoireService;
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

public class MemoireController {

    @Autowired
    private MemoireService memoire;
    
    @RequestMapping(value = "/ajoutMemoire", method = RequestMethod.POST)
    public Memoire addMemoire(@RequestBody Memoire memo){
        return memoire.addMemoire(memo);
    }
    
    @RequestMapping(value = "/listMemoire/{anneevalid}", method = RequestMethod.GET)
    public List<Memoire> getMemoireByAnneeValid(@PathParam("anneevalid") String anneevalid){
        return memoire.getMemoireByAnneeValid(anneevalid);
    }
    
    @RequestMapping(value = "/listMemoire/{titre}", method = RequestMethod.GET)
    public List<Memoire> getMemoireByTitre(@PathParam("titre") String titre){
        return memoire.getMemoireByTitre(titre);
    }
    
    @RequestMapping(value = "/listMemoire/{cycle}", method = RequestMethod.GET)
    public List<Memoire> getMemoireByCycle(@PathParam("cycle") Cycle cycle){
        return memoire.getMemoireByCycle(cycle);
    }
    
    @RequestMapping(value = "/listMemoire/{motcle}", method = RequestMethod.GET)
    public List<Memoire> getMemoireByMotCle(@PathParam("motcle") String motcle){
        return memoire.getMemoireByMotCle(motcle);
    }
    
    @RequestMapping(value = "/modifMemoire", method = RequestMethod.GET)
    public Memoire updateMemoire(@RequestBody Memoire memo){
        return memoire.editMemoire(memo);
    }
}
