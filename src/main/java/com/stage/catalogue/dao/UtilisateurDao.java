package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Role;
import com.stage.catalogue.entity.Utilisateur;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cellule
 */
@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer>{
    public List<Utilisateur> findUtilisateurByRoleUtilisateur(Role roleUtilisateur);
    public Utilisateur findUtilisateurByLoginAndPasswordAndRoleUtilisateur(String login, String password, Role roleUtilisateur);
}
