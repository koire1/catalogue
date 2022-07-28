package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Etudiant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cellule
 */
@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Integer>{
    public Etudiant findEtudiantByMatricule(String matricule);
    public List<Etudiant> findEtudiantByNomEtudiant(String nomEtudiant);
}
