package com.stage.catalogue.service;

import com.stage.catalogue.dao.AuteurDao;
import com.stage.catalogue.entity.Auteur;
import com.stage.catalogue.entity.Livre;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author cellule
 */
@Service
public class AuteurService {

    @Autowired
    private AuteurDao auteurDao;

    public Auteur addAuteur(Auteur aut) {
        return auteurDao.save(aut);
    }

    public Auteur getAuteurById(Long idAuteur) {
        return auteurDao.findById(idAuteur).orElse(null);
    }

    public List<Auteur> getAll() {
        return auteurDao.findAll();
    }

    public Page<Auteur> getAuteurByNom(String nomAuteur, int page, int size) {
        return auteurDao.findByNomAuteur(nomAuteur, PageRequest.of(page, size));
    }

    public Auteur editAuteur(Auteur auteur) {
        Optional<Auteur> oAuteur = auteurDao.findById(auteur.getId());
        if (oAuteur.isPresent()) {
            Auteur existingAuteur = oAuteur.get();
            existingAuteur.setNomAuteur(auteur.getNomAuteur());
            return auteurDao.save(existingAuteur);
        }
        return null;
    }

    public void dropAuteurById(Long idAuteur) {
        auteurDao.deleteById(idAuteur);
    }
    
    public List<Livre> getLivres(String nomAuteur){
        Optional<Auteur> oAuteur = auteurDao.findAuteurByNomAuteur(nomAuteur);
        
        if(oAuteur.isPresent()){
            return oAuteur.get().getLivres();
        }
        return null;
    }
}
