package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Role;
import com.stage.catalogue.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cellule
 */
@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer>{
    public Utilisateur findUtilisateurByNameAndPasswordAndLogin(String name, String password, Role login);
    public Utilisateur findByName(String name);
    public Utilisateur findUtilisateurByIdUtilisateur(Integer idUtilisateur);
}
