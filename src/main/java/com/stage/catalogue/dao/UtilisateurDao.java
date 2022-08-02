package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Role;
import com.stage.catalogue.entity.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cellule
 */
@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer>{
    public Page<Utilisateur> findUtilisateurByRoleUtilisateur(Role roleUtilisateur, Pageable pageable);
    public Utilisateur findUtilisateurByLoginAndPassword(String login, String password);
}
