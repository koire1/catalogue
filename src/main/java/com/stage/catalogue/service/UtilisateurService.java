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

    public Utilisateur editUtilisateur(Utilisateur utilisateur) {

        Optional<Utilisateur> oUtilisateur = utilisateurDao.findById(utilisateur.getId());
        if (oUtilisateur.isPresent()) {
            Utilisateur existingUtilisateur = oUtilisateur.get();
            existingUtilisateur.setName(utilisateur.getName());
            // TODO je ne suis pas sur que l'on modifie facilement le mot de passe ainsi
            existingUtilisateur.setPassword(utilisateur.getPassword());
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
}
