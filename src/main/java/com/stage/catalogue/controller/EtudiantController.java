package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Etudiant;
import com.stage.catalogue.service.EtudiantService;
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
@RequestMapping("/etudiant")

public class EtudiantController {

    @Autowired
    private EtudiantService etudiant;
    
    @PostMapping()
    public Etudiant addEtudiant(@RequestBody Etudiant etud){
        return etudiant.addEtudiant(etud);
    }
    
    @GetMapping(value = "/matricule")
    public Etudiant getEtudiantByMatricule(@PathParam("matricule") String matricule){
        return etudiant.getEtudiantByMatricule(matricule);
    }
    
    @GetMapping(value = "/nometudiant")
    public List<Etudiant> getEtudiantByNomEtudiant(@PathParam("nomEtudiant") String nomEtudiant){
        return etudiant.getEtudiantByNom(nomEtudiant);
    }
    
    @GetMapping(value = "/all")
    public List<Etudiant> getAllEtudiant(){
        return etudiant.getAllEtudiant();
    }
    
    @PutMapping(value = "/edit")
    public Etudiant updateEtudiant(@RequestBody Etudiant etud, int idEtudiant){
        return etudiant.editEtudiantById(etud, idEtudiant);
    }
    
    @DeleteMapping(value = "/delete")
    public void dropEtudiantById(@PathParam("idEtudiant") int idEtudiant){
        etudiant.dropEtudiantById(idEtudiant);
    }
}
