package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Departement;
import com.stage.catalogue.service.DepartementService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author cellule
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/app")

public class DepartementController {

    @Autowired
    private DepartementService departement;

    @RequestMapping(value = "/ajoutDepartement", method = RequestMethod.POST)
    public Departement addDepartement(@RequestBody Departement depart){
        return departement.addDepartement(depart);
    }
    
    @RequestMapping(value = "/listDepartement/{nomDepart}", method = RequestMethod.GET)
    public List<Departement> getDepartement(@PathParam("nomDepart") String nomDepart){
        return departement.getDepartement(nomDepart);
    }
    
    @RequestMapping(value = "/modifDepartement", method = RequestMethod.GET)
    public Departement updateDepartement(@RequestBody Departement depart){
        return departement.editDepartement(depart);
    }
}
