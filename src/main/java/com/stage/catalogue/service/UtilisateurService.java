package com.stage.catalogue.service;

import com.stage.catalogue.dao.UtilisateurDao;
import com.stage.catalogue.entity.Utilisateur;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cellule
 */
@Service
public class UtilisateurService {

    @Autowired
    public UtilisateurDao utilisateurDao;

    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
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
            existingUtilisateur.setName(utilisateur.getName());
            // TODO je ne suis pas sur que l'on modifie facilement le mot de passe ainsi
            existingUtilisateur.setPassword(editPassword(existingUtilisateur.getPassword(), utilisateur.getPassword()));
            existingUtilisateur.setEmail(utilisateur.getEmail());
            existingUtilisateur.setRole(utilisateur.getRole());
            existingUtilisateur.setUsername(utilisateur.getUsername());
            return utilisateurDao.save(existingUtilisateur);
        }
        return null;
    }
    
    public String editPassword(String password, String newPassword){
        Optional<Utilisateur> user = utilisateurDao.findByPassword(password);
        if(user.isPresent() && newPassword != password){
            Utilisateur userNew = user.get();
            userNew.setPassword(newPassword);
            return userNew.getPassword();
        }
        return null;
    }

    public void deleteById(long idUtilisateur) {
        utilisateurDao.deleteById(idUtilisateur);
    }
}
