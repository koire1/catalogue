package com.stage.catalogue.service;

import com.stage.catalogue.dao.UtilisateurDao;
import com.stage.catalogue.entity.Role;
import com.stage.catalogue.entity.Utilisateur;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/**
 *
 * @author cellule
 */
@Service
public class UtilisateurService {
    
    @Autowired
    public UtilisateurDao utilisateur;
    
    public ResponseEntity<Utilisateur> addUtilisateur(Utilisateur util){
        Utilisateur ut = utilisateur.save(util);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                       .path("/{id}")
                       .buildAndExpand(ut.getIdUtilisateur())
                       .toUri();
        return ResponseEntity.created(location).body(ut);
    }
    
    public Utilisateur getUtilisateurByLoginAndPassword(String login, String password){
        return utilisateur.findUtilisateurByLoginAndPassword(login, password);
    }
    
    public Page<Utilisateur> getUtilisateurByRole(Role roleUtilisateur, int page, int size){
        return utilisateur.findUtilisateurByRoleUtilisateur(roleUtilisateur, PageRequest.of(page, size));
    }
    
    public Page<Utilisateur> findAll(int page, int size){
        return utilisateur.findAll(PageRequest.of(page, size));
        
    }
    public ResponseEntity<Utilisateur> editUtilisateur(Utilisateur util, int idUtilisateur){
        return utilisateur.findById(idUtilisateur).map(
               c ->{
                   c.setLogin(util.getLogin());
                   c.setPassword(util.getPassword());
                   return ResponseEntity.ok(utilisateur.save(c));
               }).orElse(
                       ResponseEntity.notFound().build()
               );
    }
    
    public void deleteById(int idUtilisateur){
        utilisateur.deleteById(idUtilisateur);
    }
}
