package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Utilisateur;
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
public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {

    public Optional<Utilisateur> findByUserName(String username);

    public Page<Utilisateur> findByName(String name, Pageable page);

    public Optional<Utilisateur> findByEmail(String email);

}
