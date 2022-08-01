package com.stage.catalogue.service;

import com.stage.catalogue.dao.EtudiantDao;
import com.stage.catalogue.entity.Etudiant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    public List<Etudiant> getEtudiantByNom(String nomEtudiant){
        return etudiant.findEtudiantByNomEtudiant(nomEtudiant);
    }
    
    public Etudiant getEtudiantByMatricule(String matricule){
        return etudiant.findEtudiantByMatricule(matricule);
    }
    
    public List<Etudiant> getAllEtudiant(){
        return etudiant.findAll();
    }
    
    public Etudiant editEtudiantById(Etudiant etud, int idEtudiant){
        Etudiant existingEtudiant = etudiant.findById(idEtudiant).orElse(null);
                 existingEtudiant.setMatricule(etud.getMatricule());
                 existingEtudiant.setNomEtudiant(etud.getNomEtudiant());
                 existingEtudiant.setPrenomEtudiant(etud.getPrenomEtudiant());
        return etudiant.save(etud);
    }
    
    public void dropEtudiantById(int idEtudiant){
        etudiant.deleteById(idEtudiant);
    }
}
