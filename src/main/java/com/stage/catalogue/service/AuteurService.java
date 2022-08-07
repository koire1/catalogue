package com.stage.catalogue.service;

import com.stage.catalogue.dao.AuteurDao;
import com.stage.catalogue.entity.Auteur;
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

    public Auteur getAuteurById(long idAuteur) {
        return auteurDao.findById(idAuteur).orElse(null);
    }

    public List<Auteur> getAll() {
        return auteurDao.findAll();
    }

    public Page<Auteur> getAuteurByNom(String nomAuteur, int page, int size) {
        return auteurDao.findByNom(nomAuteur, PageRequest.of(page, size));
    }

    public Auteur editAuteur(Auteur auteur) {
        Optional<Auteur> oAuteur = auteurDao.findById(auteur.getId());
        if (oAuteur.isPresent()) {
            Auteur existingAuteur = oAuteur.get();
            existingAuteur.setNom(auteur.getNom());
            return auteurDao.save(existingAuteur);
        }
        return null;
    }

    public void dropAuteurById(long idAuteur) {
        auteurDao.deleteById(idAuteur);
    }
}
