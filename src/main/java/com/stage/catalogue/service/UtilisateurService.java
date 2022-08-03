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
    
    public Utilisateur getUtilisateurByLoginAndPasswordAndNom(Role login, String password, String nom){
        return utilisateur.findUtilisateurByLoginAndPasswordAndNom(login, password, nom);
    }
    
    public Utilisateur getUtilisateurByNom(String nom){
        return utilisateur.findByNom(nom);
    }
    
    public List<Utilisateur> getAll(){
        return utilisateur.findAll();
        
    }
    public Utilisateur editUtilisateur(Utilisateur util, int idUtilisateur){
       Utilisateur existingUtilisateur = utilisateur.findUtilisateurByIdUtilisateur(idUtilisateur);
                   existingUtilisateur.setLogin(util.getLogin());
                   existingUtilisateur.setNom(util.getNom());
                   existingUtilisateur.setPassword(util.getPassword());
        return utilisateur.save(existingUtilisateur);
    }
    
    public void deleteById(int idUtilisateur){
        utilisateur.deleteById(idUtilisateur);
    }
}
