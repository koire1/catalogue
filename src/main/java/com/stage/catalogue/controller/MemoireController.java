package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Diplome;
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
@RequestMapping("${apiPrefix}/memoires")

public class MemoireController {

    @Autowired
    private MemoireService memoireService;
    
    @PostMapping()
    public Memoire addMemoire(@RequestBody Memoire memo){
        return memoireService.addMemoire(memo);
    }
    
    @GetMapping()
    public Page<Memoire> getAllMemoire(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return memoireService.findAll(page, size);
    }
    
    // TODO I need to revise this
    @GetMapping("/anneeValid")
    public Page<Memoire> getMemoireByAnneeValid(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size, @PathParam("anneevalid") String anneevalid){
        return memoireService.getMemoireByAnneeValid(anneevalid, page, size);
    }
    
    // TODO I need to revise this
    @GetMapping("/titre")
    public Page<Memoire> getMemoireByTitre(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size, @PathParam("titre") String titre){
        return memoireService.getMemoireByTitre(titre, page, size);
    }
    
    // TODO I need to revise this
    @GetMapping("/cycle")
    public Page<Memoire> getMemoireByCycle(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size, @PathParam("cycle") Diplome cycle){
        return memoireService.getMemoireByCycle(cycle, page, size);
    }
    
    // TODO I need to revise this
    @GetMapping("/motCle")
    public Page<Memoire> getMemoireByMotCle(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size, @PathParam("motcle") String motcle){
        return memoireService.getMemoireByMotCle(motcle, page, size);
    }
    
    @PutMapping(value = "/{id}")
    public Memoire updateMemoireById(Memoire memo, @PathVariable("idMemoire") long idMemoire){
        return memoireService.editMemoireById(memo);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropMemoireById(@PathVariable("idMemoire") long idMemoire){
        memoireService.dropMemoireById(idMemoire);
    }
}
