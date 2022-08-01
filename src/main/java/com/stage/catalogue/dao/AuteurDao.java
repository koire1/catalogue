package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cellule
 */
@Repository
public interface AuteurDao extends JpaRepository<Auteur, Integer>{
    public Auteur findAuteurByIdAuteur(int idAuteur);
    public Auteur findAuteurByNomAuteur(String nomAuteur);
}
