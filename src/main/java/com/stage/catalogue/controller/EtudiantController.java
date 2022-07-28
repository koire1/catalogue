package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Etudiant;
import com.stage.catalogue.service.EtudiantService;
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

public class EtudiantController {

    @Autowired
    private EtudiantService etudiant;
    
    @RequestMapping(value = "/ajoutEtudiant", method = RequestMethod.POST)
    public Etudiant addEtudiant(@RequestBody Etudiant etud){
        return etudiant.addEtudiant(etud);
    }
    
    @RequestMapping(value = "/listEtudiant/{matricule}", method = RequestMethod.GET)
    public Etudiant getEtudiantByMatricule(@PathParam("matricule") String matricule){
        return etudiant.getEtudiantByMatricule(matricule);
    }
    
    @RequestMapping(value = "/listEtudiant/{nometudiant}", method = RequestMethod.GET)
    public List<Etudiant> getEtudiantByNomEtudiant(@PathParam("nomEtudiant") String nomEtudiant){
        return etudiant.getEtudiantByNom(nomEtudiant);
    }
    
    @RequestMapping(value = "modifEtudiant", method = RequestMethod.GET)
    public Etudiant updateEtudiant(@RequestBody Etudiant etud){
        return etudiant.editEtudiant(etud);
    }
}
