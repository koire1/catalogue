package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Departement;
import com.stage.catalogue.service.DepartementService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/departement")

public class DepartementController {

    @Autowired
    private DepartementService departement;

    @PostMapping()
    public Departement addDepartement(@RequestBody Departement depart){
        return departement.addDepartement(depart);
    }
    
    @GetMapping(value = "/nom")
    public Departement getDepartementByNomDepart(@PathParam("nomDepart") String nomDepart){
        return departement.getDepartementByNomDepart(nomDepart);
    }
    
    @GetMapping(value = "/all")
    public List<Departement> getAllDepartement(){
        return departement.getAllDepartement();
    }
    
    @PutMapping(value = "/edit")
    public Departement updateDepartementById(@RequestBody Departement depart, @PathParam("idDepart") int idDepart){
        return departement.editDepartement(depart, idDepart);
    }
    
    @DeleteMapping(value = "/delete")
    public void dropDepartementById(@PathParam("idDepart") int idDepart){
        departement.dropDepartementByIdDepart(idDepart);
    }
}
