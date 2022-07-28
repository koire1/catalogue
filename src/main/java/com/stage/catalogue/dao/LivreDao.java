package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Langue;
import org.springframework.stereotype.Repository;

import com.stage.catalogue.entity.Livre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author cellule
 */
@Repository
public interface LivreDao extends JpaRepository<Livre, Integer>{
    public Livre findLivreByIsbn(String isbn);
    public List<Livre> findLivreByTitre(String titre);
    public Livre findLivreByCote(String cote);
    public List<Livre> findLivreByAnneePub(String anneePub);
    public List<Livre> findLivreByMaisonEdit(String maisonEdit);
    public List<Livre> findLivreByTitreAndLangue(String titre, Langue langue);
}
