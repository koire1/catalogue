package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Etudiant;
import com.stage.catalogue.service.EtudiantService;
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
@RequestMapping("/etudiant")

public class EtudiantController {

    @Autowired
    private EtudiantService etudiant;
    
    @PostMapping()
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etud){
        return etudiant.addEtudiant(etud);
    }
    
    @GetMapping()
    public ResponseEntity<Etudiant> getEtudiantByMatricule(@PathParam("matricule") String matricule){
        return etudiant.getEtudiantByMatricule(matricule);
    }
    
    @GetMapping()
    public Page<Etudiant> getEtudiantByNomEtudiant(@PathParam("nomEtudiant") String nomEtudiant, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return etudiant.getEtudiantByNom(nomEtudiant, page, size);
    }
    
    @GetMapping(value = "/all")
    public Page<Etudiant> getAllEtudiant(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return etudiant.getAllEtudiant(page, size);
    }
    
    @PutMapping(value = "/edit")
    public ResponseEntity<Etudiant> updateEtudiant(Etudiant etud, @PathParam("idEtudiant") int idEtudiant){
        return etudiant.editEtudiantById(etud, idEtudiant);
    }
    
    @DeleteMapping(value = "/delete/{id: \\id+}")
    public void dropEtudiantById(@PathParam("idEtudiant") int idEtudiant){
        etudiant.dropEtudiantById(idEtudiant);
    }
}
