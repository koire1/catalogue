package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Langue;
import org.springframework.stereotype.Repository;

import com.stage.catalogue.entity.Livre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author cellule
 */
@Repository
public interface LivreDao extends JpaRepository<Livre, Integer>{
    public Livre findLivreByIsbn(String isbn);
    public Page<Livre> findLivreByTitre(String titre, Pageable pageable);
    public Livre findLivreByCote(String cote);
    public Page<Livre> findLivreByAnneePub(String anneePub, Pageable pageable);
    public Page<Livre> findLivreByMaisonEdit(String maisonEdit, Pageable pageable);
    public Page<Livre> findLivreByTitreAndLangue(String titre, Langue langue, Pageable pageable);
    public Page<Livre> findLivreByIdAuteur(AuteurDao auteur, int idAuteur);
}
