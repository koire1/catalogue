package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Auteur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cellule
 */
@Repository
public interface AuteurDao extends JpaRepository<Auteur, Long> {

    public Page<Auteur> findByNom(String nomAuteur, Pageable pageable);
}
