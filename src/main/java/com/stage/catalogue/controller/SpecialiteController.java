package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Specialite;
import com.stage.catalogue.service.SpecialiteService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author cellule
 */
@RestController
@RequestMapping("${apiPrefix}/specialites")

public class SpecialiteController {

    @Autowired
    private SpecialiteService specialiteService;
    
    @PostMapping()
    public Specialite addSpecialite(@RequestBody Specialite special){
        return specialiteService.addSpecialite(special);
    }
    
    // TODO I need to revise this
    @GetMapping
    public Specialite getSpecialiteByNomSpecialite(@PathParam("nomspecialite") String nomSpecialite){
        return specialiteService.getSpecialiteByNomSpecialite(nomSpecialite);
    }
    
    @GetMapping(value = "/{id}")
    public Specialite getSpecialiteById(@PathVariable("id") long idSpecialite){
        return specialiteService.getSpecialiteById(idSpecialite);
    }
    
    @GetMapping()
    public List<Specialite> getAll(){
        return specialiteService.getAll();
    }
    
    @PutMapping(value = "/{id}")
    public Specialite updateSpecialite(@RequestBody Specialite special, @PathVariable("id") long idSpecialite){
        return specialiteService.editSpecialite(special);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteSpecialiteById(@PathVariable("id") long idSpecialite){
        specialiteService.deleteSpecialiteById(idSpecialite);
    }
}
