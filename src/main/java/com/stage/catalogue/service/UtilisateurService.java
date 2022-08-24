package com.stage.catalogue.service;

import com.stage.catalogue.dao.UtilisateurDao;
import com.stage.catalogue.entity.Utilisateur;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author cellule
 */
@Service
public class UtilisateurService{

    @Autowired
    private UtilisateurDao utilisateurDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        return utilisateurDao.save(utilisateur);
    }

    public List<Utilisateur> getAll() {
        return utilisateurDao.findAll();

    }
    
    public Optional<Utilisateur> getUtilisateurByUsername(String username){
        return utilisateurDao.findByUsername(username);
    }

    public Utilisateur editUtilisateur(Utilisateur utilisateur, Long id) {

        Optional<Utilisateur> oUtilisateur = utilisateurDao.findById(id);
        
        if (oUtilisateur.isPresent()) {
            Utilisateur existingUtilisateur = oUtilisateur.get();
            existingUtilisateur.setEmail(utilisateur.getEmail());
            existingUtilisateur.setRole(utilisateur.getRole());
            existingUtilisateur.setUsername(utilisateur.getUsername());
            return utilisateurDao.save(existingUtilisateur);
        }
        return null;
    }
   
    public Utilisateur editPassword(String password, String newPassword, long id){
        
        Optional<Utilisateur> user = utilisateurDao.findById(id);
        String temp = user.get().getPassword();
        
        if(user.isPresent() && password.equalsIgnoreCase(temp)){
            
            Utilisateur userNew = user.get();
            userNew.setPassword(passwordEncoder.encode(newPassword));
            return utilisateurDao.save(userNew);
            
        }
        
        return null;
    }

    public void deleteById(Long idUtilisateur) {
        utilisateurDao.deleteById(idUtilisateur);
    }
    
    public Optional<Utilisateur> findByUsername(String username){
        return utilisateurDao.findByUsername(username);
    }
}
