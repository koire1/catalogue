package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Diplome;
import com.stage.catalogue.entity.Memoire;
import com.stage.catalogue.service.MemoireService;
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
    public Page<Memoire> getAllMemoire(@RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "10") int size){
        return memoireService.findAll(page, size);
    }
    
    @GetMapping(value = "/{anneevalid}")
    public Page<Memoire> getMemoireByAnneeValid(@RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "10") int size, @PathVariable("anneevalid") String anneevalid){
        return memoireService.getMemoireByAnneeValid(anneevalid, page, size);
    }
    
    @GetMapping(value = "/{titre}")
    public Page<Memoire> getMemoireByTitre(@RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "10") int size, @PathVariable("titre") String titre){
        return memoireService.getMemoireByTitre(titre, page, size);
    }
    
    @GetMapping(value = "/{cycle}")
    public Page<Memoire> getMemoireByCycle(@RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "10") int size, @PathVariable("cycle") Diplome cycle){
        return memoireService.getMemoireByCycle(cycle, page, size);
    }
    
    @GetMapping(value = "/{motcle}")
    public Page<Memoire> getMemoireByMotCle(@RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "10") int size, @PathVariable("motcle") String motcle){
        return memoireService.getMemoireByMotCle(motcle, page, size);
    }
   
    @PutMapping(value = "/{id}")
    public Memoire updateMemoireById(Memoire memo, @PathVariable("id") long idMemoire){
        return memoireService.editMemoireById(memo);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropMemoireById(@PathVariable("id") long idMemoire){
        memoireService.dropMemoireById(idMemoire);
    }
}
