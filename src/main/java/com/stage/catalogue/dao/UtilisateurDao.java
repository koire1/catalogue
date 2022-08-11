package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Role;
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

    public Optional<Utilisateur> findByUsername(String username);

    public Page<Utilisateur> findByUsername(String username, Pageable page);

    public Optional<Utilisateur> findByEmail(String email);
    
    public Optional<Utilisateur> findByPassword(String password);
    
    public Utilisateur findByNameAndPasswordAndRole(String name, String password, Role role);

}
