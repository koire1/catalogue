package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Etudiant;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cellule
 */
@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Long> {

    public Optional<Etudiant> findByMatricule(String matricule);

    public Page<Etudiant> findByNomLike(String nomEtudiant, Pageable pageable);
}
