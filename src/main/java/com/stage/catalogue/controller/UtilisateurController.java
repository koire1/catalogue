package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Utilisateur;
import com.stage.catalogue.entity.Role;
import com.stage.catalogue.service.UtilisateurService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Utilisateur addUtilisateur(@RequestBody Utilisateur util){
        return utilisateur.addUtilisateur(util);
    }
    
    @GetMapping(value = "/roleutilisateur")
    public List<Utilisateur> getUtilisateurByRole(@PathParam("roleUtilisateur") Role roleUtilisateur){
        return utilisateur.getUtilisateurByRole(roleUtilisateur);
    }
    
    @GetMapping(value = "/all")
    public List<Utilisateur> getAll(){
        return utilisateur.findAll();
    }
    
    @PostMapping(value = "/login")
    public Utilisateur loginUtilisateur(@RequestBody Utilisateur util)
    throws Exception{
        
            String tempLogin = util.getLogin();
            String tempPassword = util.getPassword();
            Role tempRoleUtilisateur = util.getRoleUtilisateur();
            Utilisateur utilObject = null;
            
            if(tempLogin != null && tempPassword != null && tempRoleUtilisateur != null){
                utilObject = utilisateur.getUtilisateurByLoginAndPasswordAndRoleUtilisateur(tempLogin, tempPassword, tempRoleUtilisateur);
           }if(utilObject == null){
               throw new Exception("Bad credentials");
           }
           return utilObject;
    }
    
    @PutMapping(value = "/edit")
    public Utilisateur updateUtilisateur(@RequestBody Utilisateur util){
        return utilisateur.editUtilisateur(util);
    }
    
    @DeleteMapping(value = "/delete")
    public void dropUtilisateurById(@PathParam("idUtilisateur") int idUtilisateur){
        utilisateur.deleteById(idUtilisateur);
    }
}
