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

    public Utilisateur editUtilisateur(Utilisateur utilisateur) {

        Optional<Utilisateur> oUtilisateur = utilisateurDao.findById(utilisateur.getId());
        if (oUtilisateur.isPresent()) {
            Utilisateur existingUtilisateur = oUtilisateur.get();
            existingUtilisateur.setName(utilisateur.getName());
            // TODO je ne suis pas sur que l'on modifie facilement le mot de passe ainsi
            existingUtilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
            existingUtilisateur.setEmail(utilisateur.getEmail());
            existingUtilisateur.setRole(utilisateur.getRole());
            existingUtilisateur.setUsername(utilisateur.getUsername());
            return utilisateurDao.save(existingUtilisateur);
        }
        return null;
    }

    public void deleteById(long idUtilisateur) {
        utilisateurDao.deleteById(idUtilisateur);
    }
    
    public Optional<Utilisateur> findByUsername(String username){
        return utilisateurDao.findByUsername(username);
    }
}
