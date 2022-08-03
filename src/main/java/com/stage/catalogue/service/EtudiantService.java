package com.stage.catalogue.service;

import com.stage.catalogue.dao.EtudiantDao;
import com.stage.catalogue.entity.Etudiant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
/**
 *
 * @author cellule
 */
@Service
public class EtudiantService {
    
    @Autowired
    private EtudiantDao etudiant;
    
    public Etudiant addEtudiant(Etudiant etud){
       return etudiant.save(etud);
    }
    
    public Page<Etudiant> getEtudiantByNom(String nomEtudiant, int page, int size){
        return etudiant.findEtudiantByNomEtudiant(nomEtudiant, PageRequest.of(page, size));
    }
    
    public Etudiant getEtudiantByMatricule(String matricule){
        return etudiant.findEtudiantByMatricule(matricule);
    }
    
    public List<Etudiant> getAll(){
        return etudiant.findAll();
    }
    
    public Etudiant editEtudiantById(Etudiant etud, int idEtudiant){
       Etudiant existingEtudiant = etudiant.findEtudiantByIdEtudiant(idEtudiant);
                existingEtudiant.setMatricule(etud.getMatricule());
                existingEtudiant.setNomEtudiant(etud.getNomEtudiant());
                existingEtudiant.setPrenomEtudiant(etud.getPrenomEtudiant());
        return etudiant.save(existingEtudiant);
       
    }
    
    public void dropEtudiantById(int idEtudiant){
        etudiant.deleteById(idEtudiant);
    }
}
