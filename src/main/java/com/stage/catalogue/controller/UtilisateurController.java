package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Utilisateur;
import com.stage.catalogue.entity.Role;
import com.stage.catalogue.service.UtilisateurService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author cellule
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/app")
public class UtilisateurController {
    
    @Autowired
    private UtilisateurService utilisateur;
    
    @RequestMapping(value = "/ajoutUtilisateur", method = RequestMethod.POST)
    public Utilisateur addUtilisateur(@RequestBody Utilisateur util){
        return utilisateur.addUtilisateur(util);
    }
    
    @RequestMapping(value = "/listUtilisateur{roleutilisateur}", method = RequestMethod.GET)
    public List<Utilisateur> getUtilisateurByRole(@PathParam("roleUtilisateur") Role roleUtilisateur){
        return utilisateur.getUtilisateurByRole(roleUtilisateur);
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
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
    
    @RequestMapping(value = "/modifUilisateur", method = RequestMethod.GET)
    public Utilisateur updateUtilisateur(@RequestBody Utilisateur util){
        return utilisateur.editUtilisateur(util);
    }
}
