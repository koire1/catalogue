package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cellule
 */
@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Integer>{
    public Etudiant findEtudiantByMatricule(String matricule);
    public Page<Etudiant> findEtudiantByNomEtudiant(String nomEtudiant, Pageable pageable);
    public Etudiant findEtudiantByIdEtudiant(Integer idEtudiant);
}
