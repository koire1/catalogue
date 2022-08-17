package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Utilisateur;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cellule
 */
@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {

    public Optional<Utilisateur> findByUsername(String username);

    public Optional<Utilisateur> findByEmail(String email);
      
}
