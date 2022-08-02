package com.stage.catalogue.service;

import com.stage.catalogue.dao.AuteurDao;
import com.stage.catalogue.dao.CategorieDao;
import com.stage.catalogue.dao.LivreDao;
import com.stage.catalogue.entity.Langue;
import com.stage.catalogue.entity.Livre;
import com.stage.catalogue.entity.Auteur;
import com.stage.catalogue.entity.Categorie;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/**
 *
 * @author cellule
 */
@Service
public class LivreService {
    @Autowired
    private LivreDao livre;
    
    @Autowired
    private AuteurDao auteur;
    
    @Autowired
    private CategorieDao categorie;
    
    public ResponseEntity<Livre> addLivre(Livre liv){
        Livre li = livre.save(liv);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                       .path("/{id}")
                       .buildAndExpand(li.getIdLivre())
                       .toUri();
        return ResponseEntity.created(location).body(li);
    }
    
    public ResponseEntity<Livre> getLivreByIsbn(String isbn){
        return livre.findLivreByIsbn(isbn);
    }
    
    public Page<Livre> getLivreByTitre(String titre, int page, int size){
        return livre.findLivreByTitre(titre, PageRequest.of(page, size));
    }
    
    public ResponseEntity<Livre> getLivreByCote(String cote){
        return livre.findLivreByCote(cote);
    }
    
    public Page<Livre> getLivreByAnneePub(String anneepub, int page, int size){
        return livre.findLivreByAnneePub(anneepub, PageRequest.of(page, size));
    }
    
    public Page<Livre> getLivreByMaisonEdit(String maisonEdit, int page, int size){
        return livre.findLivreByMaisonEdit(maisonEdit, PageRequest.of(page, size));
    }
    
    public Page<Livre> getLivreByTitreAndLangue(String titre, Langue langue, int page, int size){
        return livre.findLivreByTitreAndLangue(titre, langue, PageRequest.of(page, size));
    }
    
    public Page<Livre> getLivreByLangue(Langue langue, int page, int size){
        return livre.findLivreByLangue(langue, PageRequest.of(page, size));
    }
    
    public Page<Livre> findAll(int page, int size){
        return livre.findAll(PageRequest.of(page, size));
    }
    
    public ResponseEntity<Livre> editLivreById(Livre liv, int idLivre){
        return livre.findById(idLivre).map(
                c ->{
                    c.setAnneePub(liv.getAnneePub());
                    c.setCote(liv.getCote());
                    c.setIsbn(liv.getIsbn());
                    c.setLangue(liv.getLangue());
                    c.setMaisonEdit(liv.getMaisonEdit());
                    c.setNbrePage(liv.getNbrePage());
                    c.setNbreVueLivre(liv.getNbreVueLivre());
                    c.setTitre(liv.getTitre());
                    c.setFile(liv.getImage().getBytes());
                    Auteur nom = auteur.findByNomAuteur(liv.getAuteur().getNomAuteur());
                    c.setAuteur(nom);
                    Categorie name = categorie.findByNomCategorie(liv.getCategorie().getNomCategorie());
                    c.setCategorie(name);
                    return ResponseEntity.ok(livre.save(c));
                }).orElse(
                       ResponseEntity.notFound().build()
               );
    }
    
    public void dropLivreById(int idLivre){
        livre.deleteById(idLivre);
    }
}