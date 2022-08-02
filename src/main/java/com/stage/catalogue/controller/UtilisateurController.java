package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Utilisateur;
import com.stage.catalogue.entity.Role;
import com.stage.catalogue.service.UtilisateurService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author cellule
 */
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
    
    @Autowired
    private UtilisateurService utilisateur;
    
    @GetMapping()
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur util){
        return utilisateur.addUtilisateur(util);
    }
    
    @GetMapping()
    public Page<Utilisateur> getUtilisateurByRole(@PathParam("roleUtilisateur") Role roleUtilisateur, @DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return utilisateur.getUtilisateurByRole(roleUtilisateur, page, size);
    }
    
    @GetMapping(value = "/all")
    public Page<Utilisateur> getAll(@DefaultValue("0") @RequestParam("page") int page, @DefaultValue("10") @RequestParam("size") int size){
        return utilisateur.findAll(page, size);
    }
    
    @PostMapping(value = "/login")
    public Utilisateur loginUtilisateur(@RequestBody Utilisateur util)
    throws Exception{
        
            String tempLogin = util.getLogin();
            String tempPassword = util.getPassword();
            Utilisateur utilObject = null;
            
            if(tempLogin != null && tempPassword != null){
                utilObject = utilisateur.getUtilisateurByLoginAndPassword(tempLogin, tempPassword);
           }if(utilObject == null){
               throw new Exception("Bad credentials");
           }
           return utilObject;
    }
    
    @PutMapping(value = "/edit")
    public ResponseEntity<Utilisateur> updateUtilisateur(Utilisateur util, @PathParam("idUtilisateur") int idUtilisateur){
        return utilisateur.editUtilisateur(util, idUtilisateur);
    }
    
    @DeleteMapping(value = "/delete/{id: \\id+}")
    public void dropUtilisateurById(@PathParam("idUtilisateur") int idUtilisateur){
        utilisateur.deleteById(idUtilisateur);
    }
}
