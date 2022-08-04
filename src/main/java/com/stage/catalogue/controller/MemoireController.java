package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Cycle;
import com.stage.catalogue.entity.Memoire;
import com.stage.catalogue.service.MemoireService;
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
@RequestMapping("/memoires")

public class MemoireController {

    @Autowired
    private MemoireService memoire;
    
    @PostMapping()
    public Memoire addMemoire(@RequestBody Memoire memo){
        return memoire.addMemoire(memo);
    }
    
    @GetMapping(value = "/all")
    public Page<Memoire> getAllMemoire(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return memoire.findAll(page, size);
    }
    
    @GetMapping("/search/anneeValid")
    public Page<Memoire> getMemoireByAnneeValid(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size, @PathParam("anneevalid") String anneevalid){
        return memoire.getMemoireByAnneeValid(anneevalid, page, size);
    }
    
    @GetMapping("/search/titre")
    public Page<Memoire> getMemoireByTitre(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size, @PathParam("titre") String titre){
        return memoire.getMemoireByTitre(titre, page, size);
    }
    
    @GetMapping("/search/cycle")
    public Page<Memoire> getMemoireByCycle(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size, @PathParam("cycle") Cycle cycle){
        return memoire.getMemoireByCycle(cycle, page, size);
    }
    
    @GetMapping("/search/motCle")
    public Page<Memoire> getMemoireByMotCle(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size, @PathParam("motcle") String motcle){
        return memoire.getMemoireByMotCle(motcle, page, size);
    }
    
    @PutMapping(value = "/edit/{id}")
    public Memoire updateMemoireById(Memoire memo, @PathVariable("idMemoire") int idMemoire){
        return memoire.editMemoireById(memo, idMemoire);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public void dropMemoireById(@PathVariable("idMemoire") int idMemoire){
        memoire.dropMemoireById(idMemoire);
    }
}
