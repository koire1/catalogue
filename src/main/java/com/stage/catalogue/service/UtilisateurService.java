package com.stage.catalogue.service;

import com.stage.catalogue.dao.UtilisateurDao;
import com.stage.catalogue.entity.Role;
import com.stage.catalogue.entity.Utilisateur;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author cellule
 */
@Service
public class UtilisateurService {
    
    @Autowired
    public UtilisateurDao utilisateur;
    
    public Utilisateur addUtilisateur(Utilisateur util){
        return utilisateur.save(util);
    }
    
    public Utilisateur getUtilisateurByLoginAndPasswordAndRoleUtilisateur(String login, String password, Role roleUtilisateur){
        return utilisateur.findUtilisateurByLoginAndPasswordAndRoleUtilisateur(login, password, roleUtilisateur);
    }
    
    public List<Utilisateur> getUtilisateurByRole(Role roleUtilisateur){
        return utilisateur.findUtilisateurByRoleUtilisateur(roleUtilisateur);
    }
    
    public Utilisateur editUtilisateur(Utilisateur util){
        Utilisateur existingUtilisateur = utilisateur.findById(util.getIdUtilisateur()).orElse(null);
                    existingUtilisateur.setLogin(util.getLogin());
                    existingUtilisateur.setPassword(util.getPassword());
        return utilisateur.save(existingUtilisateur);
    }
}
