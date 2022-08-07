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
public interface CategorieDao extends JpaRepository<Categorie, Long> {

    public Optional<Categorie> findByNom(String nomCategorie);

    public Page<Categorie> findByNomLike(String nomCategorie, Pageable pageable);
}
