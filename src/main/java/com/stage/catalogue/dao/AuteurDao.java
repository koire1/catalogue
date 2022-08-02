package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Auteur;
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
public interface AuteurDao extends JpaRepository<Auteur, Integer>{
    public Optional<Auteur> findAuteurByIdAuteur(int idAuteur);
    public Page<Auteur> findAuteurByNomAuteur(String nomAuteur, Pageable pageable);
    public Auteur findByNomAuteur(String nomAuteur);
    public Page<Auteur> findAllUser(Pageable pageable);
}
