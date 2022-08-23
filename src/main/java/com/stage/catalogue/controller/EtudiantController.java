package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Etudiant;
import com.stage.catalogue.service.EtudiantService;
import java.util.List;
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
@RequestMapping("${apiPrefix}/etudiants")

public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;
    
    @PostMapping
    public Etudiant addEtudiant(@RequestBody Etudiant etud){
        return etudiantService.addEtudiant(etud);
    }
    
    @GetMapping(value = "/{matricule}")
    public Etudiant getEtudiantByMatricule(@PathVariable("matricule") String matricule){
        return etudiantService.getEtudiantByMatricule(matricule);
    }
    
    @GetMapping(value = "/{nometudiant}")
    public Page<Etudiant> getEtudiantByNomEtudiant(@PathVariable("nometudiant") String nomEtudiant, @RequestParam(value = "page" , defaultValue = "0") int page, @RequestParam(value = "size" , defaultValue = "0") int size){
        return etudiantService.getEtudiantByNom(nomEtudiant, page, size);
    }
   
    @GetMapping
    public List<Etudiant> getAll(){
        return etudiantService.getAll();
    }
    
    @PutMapping(value = "/{id}")
    public Etudiant updateEtudiant(Etudiant etud, @PathVariable("id") Long idEtudiant){
        return etudiantService.editEtudiantById(etud);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropEtudiantById(@PathVariable("id") Long idEtudiant){
        etudiantService.dropEtudiantById(idEtudiant);
    }
}
