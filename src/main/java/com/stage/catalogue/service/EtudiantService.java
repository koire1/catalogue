package com.stage.catalogue.service;

import com.stage.catalogue.dao.EtudiantDao;
import com.stage.catalogue.entity.Etudiant;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/**
 *
 * @author cellule
 */
@Service
public class EtudiantService {
    
    @Autowired
    private EtudiantDao etudiant;
    
    public ResponseEntity<Etudiant> addEtudiant(Etudiant etud){
        Etudiant etude = etudiant.save(etud);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                       .path("/{id}")
                       .buildAndExpand(etude.getIdEtudiant())
                       .toUri();
        return ResponseEntity.created(location).body(etude);
    }
    
    public Page<Etudiant> getEtudiantByNom(String nomEtudiant, int page, int size){
        return etudiant.findEtudiantByNomEtudiant(nomEtudiant, PageRequest.of(page, size));
    }
    
    public ResponseEntity<Etudiant> getEtudiantByMatricule(String matricule){
        return etudiant.findEtudiantByMatricule(matricule);
    }
    
    public Page<Etudiant> getAllEtudiant(int page, int size){
        return etudiant.findAll(PageRequest.of(page, size));
    }
    
    public ResponseEntity<Etudiant> editEtudiantById(Etudiant etud, int idEtudiant){
       return etudiant.findById(idEtudiant).map(
               c ->{
                   c.setMatricule(etud.getMatricule());
                   c.setNomEtudiant(etud.getNomEtudiant());
                   return ResponseEntity.ok(etudiant.save(c));
               }).orElse(
                       ResponseEntity.notFound().build()
               );
    }
    
    public void dropEtudiantById(int idEtudiant){
        etudiant.deleteById(idEtudiant);
    }
}
