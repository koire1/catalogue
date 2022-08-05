package com.stage.catalogue.controller;

import com.stage.catalogue.entity.Utilisateur;
import com.stage.catalogue.entity.Role;
import com.stage.catalogue.service.UtilisateurService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    
    @Autowired
    private UtilisateurService utilisateur;
    
    @PostMapping()
    public Utilisateur addUtilisateur(@RequestBody Utilisateur util){
        return utilisateur.addUtilisateur(util);
    }
    
    @GetMapping("/name")
    public Utilisateur getUtilisateurByName(@PathParam("name") String name){
        return utilisateur.getUtilisateurByName(name);
    }
    
    @GetMapping()
    public List<Utilisateur> getAll(){
        return utilisateur.getAll();
    }
    
    @PostMapping(value = "/login")
    public Utilisateur loginUtilisateur(@RequestBody Utilisateur util)
    throws Exception{
            String tempNom = util.getName();
            String tempPassword = util.getPassword();
            Role tempLogin = util.getLogin();
            Utilisateur utilObject = null;
            
            if(tempPassword != null && tempNom != null){
                utilObject = utilisateur.getUtilisateurByNameAndPasswordAndLogin(tempNom, tempPassword, tempLogin);
           }if(utilObject == null){
               throw new Exception("Bad credentials");
           }
           return utilObject;
    }
    
    @PutMapping(value = "/{id}")
    public Utilisateur updateUtilisateur(Utilisateur util, @PathVariable("id") int idUtilisateur){
        return utilisateur.editUtilisateur(util, idUtilisateur);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropUtilisateurById(@PathVariable("idUtilisateur") int idUtilisateur){
        utilisateur.deleteById(idUtilisateur);
    }
}
