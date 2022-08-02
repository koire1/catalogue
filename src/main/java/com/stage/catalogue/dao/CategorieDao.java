package com.stage.catalogue.dao;

import org.springframework.stereotype.Repository;

import com.stage.catalogue.entity.Categorie;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author cellule
 */
@Repository
public interface CategorieDao extends JpaRepository<Categorie, Integer>{
    public Categorie findByNomCategorie(String nomCategorie);
    public Page<Categorie> findCategorieByNomCategorie(String nomCategorie, Pageable pageable);
    public Optional<Categorie> findCategorieByIdCategorie(Integer idCategorie);
}
