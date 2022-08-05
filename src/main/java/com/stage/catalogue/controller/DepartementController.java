package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Departement;
import com.stage.catalogue.entity.Specialite;
import com.stage.catalogue.service.DepartementService;
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
@RequestMapping("/departements")

public class DepartementController {

    @Autowired
    private DepartementService departement;

    @PostMapping()
    public Departement addDepartement(@RequestBody Departement depart){
        return departement.addDepartement(depart);
    }
    
    @GetMapping("/nomdepart")
    public Page<Departement> getDepartementByNom(@PathParam("nomdepart") String nomDepart, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return departement.getDepartementByNom(nomDepart, page, size);
    }
    
    @GetMapping(value = "/{id}")
    public Departement getDepartementById(@PathVariable("id") int idDepart){
        return departement.getDepartementById(idDepart);
    }
    
    @GetMapping(value = "/{id}/specialites")
    public List<Specialite> listSpecialite(@PathVariable("id") int idDepart){
        return departement.getSpecialite(idDepart);
    }
    
    @PutMapping(value = "/{idDepart}/specialite/idSpecial")
    public Specialite modifSpecialite(@PathVariable("idDepart") int idDepart, @PathParam("idSpecial") int id, @RequestBody Specialite special){
        return departement.editSpecialite(idDepart, id, special);
    }
    
    @PostMapping(value = "/{idDepart}/specialite")
    public Specialite ajoutSpecialite(@PathVariable("idDepart") int idDepart, @RequestBody Specialite special){
        return departement.addSpecialite(special);
    }
    
    @DeleteMapping(value = "/{id}/specialite/idSpecial")
    public void suppSpecialite(@PathVariable("id") int idDepart, @PathParam("idSpecial") int idSpecial){
        departement.deleteSpecialite(idSpecial);
    }
    
    @GetMapping()
    public List<Departement> getAll(){
        return departement.getAll();
    }
    
    @PutMapping("/{id}")
    public Departement updateDepartementById(Departement depart, @PathVariable("id") int idDepart){
        return departement.editDepartement(depart, idDepart);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropDepartementById(@PathVariable("id") int idDepart){
        departement.dropDepartementById(idDepart);
    }
}
