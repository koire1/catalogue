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
@RequestMapping("${apiPrefix}/etudiants")

public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;
    
    @PostMapping()
    public Etudiant addEtudiant(@RequestBody Etudiant etud){
        return etudiantService.addEtudiant(etud);
    }
    
    // TODO need to revise this mapping
    @GetMapping
    public Etudiant getEtudiantByMatricule(@PathParam("matricule") String matricule){
        return etudiantService.getEtudiantByMatricule(matricule);
    }
    
    // TODO need to revise this mapping
    @GetMapping
    public Page<Etudiant> getEtudiantByNomEtudiant(@PathParam("nometudiant") String nomEtudiant, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return etudiantService.getEtudiantByNom(nomEtudiant, page, size);
    }
    
    @GetMapping()
    public List<Etudiant> getAll(){
        return etudiantService.getAll();
    }
    
    @PutMapping(value = "/{id}")
    public Etudiant updateEtudiant(Etudiant etud, @PathVariable("id") long idEtudiant){
        return etudiantService.editEtudiantById(etud);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropEtudiantById(@PathVariable("id") long idEtudiant){
        etudiantService.dropEtudiantById(idEtudiant);
    }
}
