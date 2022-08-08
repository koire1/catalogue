
package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Diplome;
import com.stage.catalogue.service.DiplomeService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
 * @author vincent
 */
@RestController
@RequestMapping("${apiPrefix}/diplomes")
public class DiplomeController {
    
    @Autowired
    private DiplomeService diplomeService;
    
    @PostMapping
    public Diplome create(@RequestBody Diplome diplome){
        return diplomeService.save(diplome);
    }
    
    @PutMapping("/{id}")
    public Diplome edit(@PathVariable("id") long id, @RequestBody Diplome diplome){
        Optional<Diplome> oDiplome = diplomeService.findById(id);
        if(oDiplome.isPresent()){
            Diplome d = oDiplome.get();
            d.setCode(diplome.getCode());
            d.setIntitule(diplome.getIntitule());
            return diplomeService.save(d);
        }
        return null;
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id){
        diplomeService.delete(id);
    }
    
    @GetMapping
    public Page<Diplome> find(@RequestParam(value = "page", defaultValue = "0")int page, 
                              @RequestParam(value = "size", defaultValue = "15")int size){
        return diplomeService.findAll(page, size);
    } 
    
    @GetMapping("/{id}")
    public ResponseEntity<Diplome> findOne(@PathVariable("id") long id){
        Optional<Diplome> d = diplomeService.findById(id);
        if(d.isPresent()){
            return ResponseEntity.ok(d.get());
        }
        return ResponseEntity.notFound().build();
    }
}