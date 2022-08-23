package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Departement;
import com.stage.catalogue.entity.Specialite;
import com.stage.catalogue.service.DepartementService;
import com.stage.catalogue.service.SpecialiteService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping(value = "/{nomdepart}")
    public Page<Departement> getDepartementByNom(@PathVariable("nomdepart") String nomDepart, @RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "0") int size){
        return departementService.getDepartementByNom(nomDepart, page, size);
    }
    
    @GetMapping(value = "/{id}")
    public Departement getDepartementById(@PathVariable("id") Long idDepart){
        return departementService.getDepartementById(idDepart);
    }
    
    @GetMapping(value = "/{id}/specialites")
    public List<Specialite> listSpecialite(@PathVariable("id") Long idDepart){
        return departementService.getSpecialite(idDepart);
    }
    
    @PutMapping(value = "/{idDepart}/specialite/{idSpecial}")
    public Specialite modifSpecialite(@PathVariable("idDepart") Long idDepart, @PathVariable("idSpecial") long id, @RequestBody Specialite special){
        return speciateService.editSpecialite(special);
    }
    
    @PostMapping(value = "/{idDepart}/specialite")
    public Specialite ajoutSpecialite(@PathVariable("idDepart") Long idDepart, @RequestBody Specialite special){
        Departement d = departementService.getDepartementById(idDepart);
        special.setDepartement(d);
        return speciateService.addSpecialite(special);
    }
    
    @DeleteMapping(value = "/{id}/specialite/{idSpecial}")
    public void suppSpecialite(@PathVariable("id") Long idDepart, @PathParam("idSpecial") Long idSpecial){
        speciateService.deleteSpecialiteById(idSpecial);
    }
    
    @GetMapping()
    public List<Departement> getAll(){
        return departementService.getAll();
    }
    
    @PutMapping("/{id}")
    public Departement updateDepartementById(Departement depart, @PathVariable("id") Long idDepart){
        return departementService.editDepartement(depart);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropDepartementById(@PathVariable("id") Long idDepart){
        departementService.dropDepartementById(idDepart);
    }
}
