package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Etudiant;
import com.stage.catalogue.service.EtudiantService;
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
@RequestMapping("/etudiants")

public class EtudiantController {

    @Autowired
    private EtudiantService etudiant;
    
    @PostMapping()
    public Etudiant addEtudiant(@RequestBody Etudiant etud){
        return etudiant.addEtudiant(etud);
    }
    
    @GetMapping("/search/matricule")
    public Etudiant getEtudiantByMatricule(@PathParam("matricule") String matricule){
        return etudiant.getEtudiantByMatricule(matricule);
    }
    
    @GetMapping("/search/nomEtudiant")
    public Page<Etudiant> getEtudiantByNomEtudiant(@PathParam("nometudiant") String nomEtudiant, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return etudiant.getEtudiantByNom(nomEtudiant, page, size);
    }
    
    @GetMapping(value = "/all")
    public List<Etudiant> getAll(){
        return etudiant.getAll();
    }
    
    @PutMapping(value = "/edit/{id}")
    public Etudiant updateEtudiant(Etudiant etud, @PathVariable("id") int idEtudiant){
        return etudiant.editEtudiantById(etud, idEtudiant);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public void dropEtudiantById(@PathVariable("id") int idEtudiant){
        etudiant.dropEtudiantById(idEtudiant);
    }
}
