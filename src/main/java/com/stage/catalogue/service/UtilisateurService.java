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
    
    public Utilisateur getUtilisateurByNameAndPasswordAndLogin(String name, String password, Role login){
        return utilisateur.findUtilisateurByNameAndPasswordAndLogin(name, password, login);
    }
    
    public Utilisateur getUtilisateurByName(String name){
        return utilisateur.findByName(name);
    }
    
    public List<Utilisateur> getAll(){
        return utilisateur.findAll();
        
    }
    public Utilisateur editUtilisateur(Utilisateur util, int idUtilisateur){
       Utilisateur existingUtilisateur = utilisateur.findUtilisateurByIdUtilisateur(idUtilisateur);
                   existingUtilisateur.setLogin(util.getLogin());
                   existingUtilisateur.setName(util.getName());
                   existingUtilisateur.setPassword(util.getPassword());
        return utilisateur.save(existingUtilisateur);
    }
    
    public void deleteById(int idUtilisateur){
        utilisateur.deleteById(idUtilisateur);
    }
}
