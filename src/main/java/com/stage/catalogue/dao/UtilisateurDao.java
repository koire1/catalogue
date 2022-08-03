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
    public Utilisateur findUtilisateurByLoginAndPasswordAndNom(Role login, String password, String nom);
    public Utilisateur findByNom(String nom);
    public Utilisateur findUtilisateurByIdUtilisateur(Integer idUtilisateur);
}
