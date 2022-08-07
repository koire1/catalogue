package com.stage.catalogue.service;

import com.stage.catalogue.dao.LivreDao;
import com.stage.catalogue.entity.Auteur;
import com.stage.catalogue.entity.Langue;
import com.stage.catalogue.entity.Livre;
import java.util.Date;
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
public class LivreService {

    @Autowired
    private LivreDao livreDao;

    public Livre addLivre(Livre livre) {
        return livreDao.save(livre);
    }

    public Livre getLivreByIsbn(String isbn) {
        return livreDao.findByIsbn(isbn).orElse(null);
    }

    public Page<Livre> getLivreByTitre(String titre, int page, int size) {
        return livreDao.findByTitreLike(titre, PageRequest.of(page, size));
    }

    public Livre getLivreByCote(String cote) {
        return livreDao.findByCote(cote).orElse(null);
    }

    public Page<Livre> getLivreByAnneePub(Date anneepub, int page, int size) {
        return livreDao.findByAnneePublication(anneepub, PageRequest.of(page, size));
    }

    public Page<Livre> getLivreByMaisonEdit(String maisonEdit, int page, int size) {
        return livreDao.findByMaisonEdition(maisonEdit, PageRequest.of(page, size));
    }

    public Page<Livre> getLivreByTitreAndLangue(String titre, Langue langue, int page, int size) {
        return livreDao.findByTitreLikeAndLangue(titre, langue, PageRequest.of(page, size));
    }

    public Page<Livre> getLivreByLangue(Langue langue, int page, int size) {
        return livreDao.findByLangue(langue, PageRequest.of(page, size));
    }

    public Page<Livre> findAll(int page, int size) {
        return livreDao.findAll(PageRequest.of(page, size));
    }

    public Livre editLivreById(Livre livre) {
        Optional<Livre> oLivre = livreDao.findById(livre.getId());
        if (oLivre.isPresent()) {
            Livre existingLivre = oLivre.get();
            existingLivre.setAnneePublication(livre.getAnneePublication());
            existingLivre.setAuteurs(livre.getAuteurs());
            existingLivre.setCategorie(livre.getCategorie());
            existingLivre.setCote(livre.getCote());
            existingLivre.setIsbn(livre.getIsbn());
            existingLivre.setLangue(livre.getLangue());
            existingLivre.setMaisonEdition(livre.getMaisonEdition());
            existingLivre.setNombrePages(livre.getNombrePages());
            existingLivre.setTitre(livre.getTitre());
            existingLivre.setImage(livre.getImage());
            return livreDao.save(existingLivre);
        }
        return null;
    }

    public void dropLivreById(long idLivre) {
        livreDao.deleteById(idLivre);
    }
}
