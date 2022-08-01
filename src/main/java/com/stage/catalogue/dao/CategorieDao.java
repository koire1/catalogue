package com.stage.catalogue.dao;

import org.springframework.stereotype.Repository;

import com.stage.catalogue.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author cellule
 */
@Repository
public interface CategorieDao extends JpaRepository<Categorie, Integer>{
    public Categorie findCategorieByNomCategorie(String nomCategorie);
}
