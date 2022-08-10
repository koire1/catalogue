package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Departement;
import com.stage.catalogue.entity.Specialite;
import com.stage.catalogue.service.DepartementService;
import com.stage.catalogue.service.SpecialiteService;
import java.util.List;
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
@RequestMapping("${apiPrefix}/departements")

public class DepartementController {

    @Autowired
    private DepartementService departementService;
    
    @Autowired
    private SpecialiteService speciateService;

    @PostMapping
    public Departement addDepartement(@RequestBody Departement depart){
        return departementService.addDepartement(depart);
    }
    
    @GetMapping
    public Page<Departement> getDepartementByNom(@PathParam("nomdepart") String nomDepart, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return departementService.getDepartementByNom(nomDepart, page, size);
    }
    
    @GetMapping(value = "/{id}")
    public Departement getDepartementById(@PathVariable("id") long idDepart){
        return departementService.getDepartementById(idDepart);
    }
    
    @GetMapping(value = "/{id}/specialites")
    public List<Specialite> listSpecialite(@PathVariable("id") long idDepart){
        return departementService.getSpecialite(idDepart);
    }
    
    // TODO some checks need to be performed here
    @PutMapping(value = "/{idDepart}/specialite")
    public Specialite modifSpecialite(@PathVariable("idDepart") long idDepart, @PathParam("idSpecial") long id, @RequestBody Specialite special){
        return speciateService.editSpecialite(special);
    }
    
    @PostMapping(value = "/{idDepart}/specialite")
    public Specialite ajoutSpecialite(@PathVariable("idDepart") int idDepart, @RequestBody Specialite special){
        Departement d = departementService.getDepartementById(idDepart);
        special.setDepartement(d);
        return speciateService.addSpecialite(special);
    }
    
    // TODO some checks need to be performed here
    @DeleteMapping(value = "/{id}/specialite")
    public void suppSpecialite(@PathVariable("id") long idDepart, @PathParam("idSpecial") long idSpecial){
        speciateService.deleteSpecialiteById(idSpecial);
    }
    
    @GetMapping()
    public List<Departement> getAll(){
        return departementService.getAll();
    }
    
    @PutMapping("/{id}")
    public Departement updateDepartementById(Departement depart, @PathVariable("id") long idDepart){
        return departementService.editDepartement(depart);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropDepartementById(@PathVariable("id") int idDepart){
        departementService.dropDepartementById(idDepart);
    }
}
