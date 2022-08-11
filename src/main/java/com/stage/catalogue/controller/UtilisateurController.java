package com.stage.catalogue.controller;

import com.stage.catalogue.dao.UtilisateurDao;
import com.stage.catalogue.entity.Role;
import com.stage.catalogue.entity.Utilisateur;
import com.stage.catalogue.service.UtilisateurService;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
@RequestMapping("${apiPrefix}/utilisateurs")
public class UtilisateurController {
    
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private UtilisateurDao utilisateur;
    
    @PostMapping()
    public Utilisateur addUtilisateur(@RequestBody Utilisateur util){
        return utilisateurService.addUtilisateur(util);
    }
    
    // TODO I need to revise this
    @GetMapping
    public Optional<Utilisateur> getUtilisateurByName(@PathParam("name") String name){
        return utilisateurService.getUtilisateurByUsername(name);
    }
    
    @GetMapping
    public List<Utilisateur> getAll(){
        return utilisateurService.getAll();
    }
    
//   TODO I need a better way to deal with this
    @PostMapping(value = "/login")
    public Utilisateur loginUtilisateur(@RequestBody Utilisateur util)
        throws Exception{
        Objects.requireNonNull(util.getUsername());
        Objects.requireNonNull(util.getPassword());
        Objects.requireNonNull(util.getRole());
        Utilisateur user = utilisateur.findByNameAndPasswordAndRole(util.getUsername(), util.getPassword(), util.getRole());
        return user;
    }
    
    @PutMapping(value = "/{id}")
    public Utilisateur updateUtilisateur(Utilisateur util, @PathVariable("id") long idUtilisateur){
        return utilisateurService.editUtilisateur(util, idUtilisateur);
    }
    
    @DeleteMapping(value = "/{id}")
    public void dropUtilisateurById(@PathVariable("idUtilisateur") long idUtilisateur){
        utilisateurService.deleteById(idUtilisateur);
    }
}
