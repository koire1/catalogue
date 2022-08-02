package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Langue;
import org.springframework.stereotype.Repository;

import com.stage.catalogue.entity.Livre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
/**
 *
 * @author cellule
 */
@Repository
public interface LivreDao extends JpaRepository<Livre, Integer>{
    public ResponseEntity<Livre> findLivreByIsbn(String isbn);
    public Page<Livre> findLivreByTitre(String titre, Pageable pageable);
    public ResponseEntity<Livre> findLivreByCote(String cote);
    public Page<Livre> findLivreByAnneePub(String anneePub, Pageable pageable);
    public Page<Livre> findLivreByMaisonEdit(String maisonEdit, Pageable pageable);
    public Page<Livre> findLivreByTitreAndLangue(String titre, Langue langue, Pageable pageable);
    public Page<Livre> findLivreByLangue(Langue langue, Pageable pageable);
    public Livre findByCategorie(String nomCategorie);
}
