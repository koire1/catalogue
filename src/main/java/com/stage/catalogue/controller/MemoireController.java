package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Cycle;
import com.stage.catalogue.entity.Memoire;
import com.stage.catalogue.service.MemoireService;
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
@RequestMapping("/memoire")

public class MemoireController {

    @Autowired
    private MemoireService memoire;
    
    @PostMapping(value = "/ajoutMemoire")
    public Memoire addMemoire(@RequestBody Memoire memo){
        return memoire.addMemoire(memo);
    }
    
    @GetMapping(value = "/anneevalid")
    public Page<Memoire> getMemoireByAnneeValid(@RequestParam("page") int page, @RequestParam("size") int size, @PathParam("anneevalid") String anneevalid){
        Pageable pageable = PageRequest.of(page, size);
        return memoire.getMemoireByAnneeValid(anneevalid, pageable);
    }
    
    @GetMapping(value = "/titre")
    public Page<Memoire> getMemoireByTitre(@RequestParam("page") int page, @RequestParam("size") int size, @PathParam("titre") String titre){
        Pageable pageable = PageRequest.of(page, size);
        return memoire.getMemoireByTitre(titre, pageable);
    }
    
    @GetMapping(value = "/cycle")
    public Page<Memoire> getMemoireByCycle(@RequestParam("page") int page, @RequestParam("size") int size, @PathParam("cycle") Cycle cycle){
        Pageable pageable = PageRequest.of(page, size);
        return memoire.getMemoireByCycle(cycle, pageable);
    }
    
    @GetMapping(value = "/motcle")
    public Page<Memoire> getMemoireByMotCle(@RequestParam("page") int page, @RequestParam("size") int size, @PathParam("motcle") String motcle){
        Pageable pageable = PageRequest.of(page, size);
        return memoire.getMemoireByMotCle(motcle, pageable);
    }
    
    @PutMapping(value = "/edit")
    public Memoire updateMemoire(@RequestBody Memoire memo, @PathParam("idMemoire") int idMemoire){
        return memoire.editMemoire(memo, idMemoire);
    }
    
    @DeleteMapping(value = "/delete")
    public void dropMemoireById(@RequestBody Memoire memo, @PathParam("idMemoire") int idMemoire){
        memoire.dropMemoireById(idMemoire);
    }
}
