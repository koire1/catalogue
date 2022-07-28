package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Auteur;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cellule
 */
@Repository
public interface AuteurDao extends JpaRepository<Auteur, Integer>{
    public List<Auteur> findAuteurByNomAuteur(String nomAuteur);
}
