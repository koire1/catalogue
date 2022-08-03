package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Departement;
import com.stage.catalogue.service.DepartementService;
import java.util.List;
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
@RequestMapping("/departements")

public class DepartementController {

    @Autowired
    private DepartementService departement;

    @PostMapping()
    public Departement addDepartement(@RequestBody Departement depart){
        return departement.addDepartement(depart);
    }
    
    @GetMapping("/search/{nomdepart}")
    public Page<Departement> getDepartementByNom(@PathVariable("nomdepart") String nomDepart, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return departement.getDepartementByNom(nomDepart, page, size);
    }
    
    @GetMapping(value = "/{id}")
    public Departement getDepartementById(@PathVariable("id") int idDepart){
        return departement.getDepartementById(idDepart);
    }
    
    @GetMapping(value = "/all")
    public List<Departement> getAll(){
        return departement.getAll();
    }
    
    @PutMapping("/edit/{id}")
    public Departement updateDepartementById(Departement depart, @PathVariable("id") int idDepart){
        return departement.editDepartement(depart, idDepart);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public void dropDepartementById(@PathVariable("id") int idDepart){
        departement.dropDepartementById(idDepart);
    }
}
