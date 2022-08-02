package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Departement;
import com.stage.catalogue.service.DepartementService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/departement")

public class DepartementController {

    @Autowired
    private DepartementService departement;

    @PostMapping()
    public ResponseEntity<Departement> addDepartement(@RequestBody Departement depart){
        return departement.addDepartement(depart);
    }
    
    @GetMapping()
    public Page<Departement> getDepartementByNom(@PathParam("nomDepart") String nomDepart, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return departement.getDepartementByNom(nomDepart, page, size);
    }
    
    @GetMapping(value = "{id: \\id+}")
    public ResponseEntity<Departement> getDepartementById(@PathParam("idDepart") int idDepart){
        return departement.getDepartementById(idDepart);
    }
    
    @GetMapping(value = "/all")
    public Page<Departement> getAllDepartement(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return departement.getAllDepartement(page, size);
    }
    
    @PutMapping("/edit")
    public ResponseEntity<Departement> updateDepartementById(Departement depart, @PathParam("idDepart") int idDepart){
        return departement.editDepartement(depart, idDepart);
    }
    
    @DeleteMapping(value = "/delete/{id: \\id+}")
    public void dropDepartementById(@PathParam("idDepart") int idDepart){
        departement.dropDepartementById(idDepart);
    }
}
