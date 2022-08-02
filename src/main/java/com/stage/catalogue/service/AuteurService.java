package com.stage.catalogue.service;

import com.stage.catalogue.dao.AuteurDao;
import com.stage.catalogue.entity.Auteur;
import java.net.URI;
import java.util.List;
import java.util.Optional;
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
public class AuteurService {
    @Autowired
    private AuteurDao auteur;
    
    public ResponseEntity<Auteur> addAuteur(Auteur aut){
            Auteur c = auteur.save(aut);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(c.getIdAuteur())
                .toUri();
        return ResponseEntity.created(location).body(c);    
    }
    
    public ResponseEntity<Auteur> getAuteurById(int idAuteur){
            Optional<Auteur> aut = auteur.findAuteurByIdAuteur(idAuteur);
            if (aut.isPresent()) {
            return ResponseEntity.ok(aut.get());
            }
        return ResponseEntity.notFound().build();    
    }
    
    public Page<Auteur> getAuteur(int page, int size){
        return auteur.findAllUser(PageRequest.of(page, size));
    }
    
    public Page<Auteur> getAuteurByNom(String nomAuteur, int page, int size){
        return auteur.findAuteurByNomAuteur(nomAuteur, PageRequest.of(page, size));
    }
    
    public ResponseEntity<Auteur> editAuteur(Auteur aut, int idAuteur){
        return auteur.findById(idAuteur).map(
                c -> {
                    c.setNomAuteur(aut.getNomAuteur());
                    return ResponseEntity.ok(auteur.save(c));
                }
                                     ).orElse(
                ResponseEntity.notFound().build()
        );
        
    }
    
    public void dropAuteurById(int idAuteur){
        auteur.deleteById(idAuteur);
    }
}
