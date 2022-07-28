package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Specialite;
import com.stage.catalogue.service.SpecialiteService;
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

public class SpecialiteController {

    @Autowired
    private SpecialiteService specialite;
    
    @RequestMapping(value = "/ajoutSpecialite", method = RequestMethod.POST)
    public Specialite addSpecialite(@RequestBody Specialite special){
        return specialite.addSpecialite(special);
    }
    
    @RequestMapping(value = "/listSpecialite{nomSpecialite}", method = RequestMethod.GET)
    public Specialite getSpecialiteByNomSpecialite(@PathParam("nomSpecialite") String nomSpecialite){
        return specialite.getSpecialiteByNomSpecialite(nomSpecialite);
    }
    
    @RequestMapping(value = "/modifSpecialite", method = RequestMethod.GET)
    public Specialite updateSpecialite(@RequestBody Specialite special){
        return specialite.editSpecialite(special);
    }
}
