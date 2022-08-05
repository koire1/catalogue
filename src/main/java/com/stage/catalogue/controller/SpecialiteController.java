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
@RequestMapping("/specialites")

public class SpecialiteController {

    @Autowired
    private SpecialiteService specialite;
    
    @PostMapping()
    public Specialite addSpecialite(@RequestBody Specialite special){
        return specialite.addSpecialite(special);
    }
    
    @GetMapping("/nomspecialite")
    public Specialite getSpecialiteByNomSpecialite(@PathParam("nomspecialite") String nomSpecialite){
        return specialite.getSpecialiteByNomSpecialite(nomSpecialite);
    }
    
    @GetMapping(value = "/{id}")
    public Specialite getSpecialiteById(@PathVariable("id") int idSpecialite){
        return specialite.getSpecialiteById(idSpecialite);
    }
    
    @GetMapping()
    public List<Specialite> getAll(){
        return specialite.getAll();
    }
    
    @PutMapping(value = "/{id}")
    public Specialite updateSpecialite(@RequestBody Specialite special, @PathVariable("id") int idSpecialite){
        return specialite.editSpecialiteById(special, idSpecialite);
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteSpecialiteById(@PathVariable("id") int idSpecialite){
        specialite.deleteSpecialiteById(idSpecialite);
    }
}
