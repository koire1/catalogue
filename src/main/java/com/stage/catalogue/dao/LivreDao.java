package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Langue;
import org.springframework.stereotype.Repository;
import com.stage.catalogue.entity.Livre;
import java.util.Date;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cellule
 */
@Repository
public interface LivreDao extends JpaRepository<Livre, Long> {

    public Optional<Livre> findByIsbn(String isbn);

    public Page<Livre> findByTitreLike(String titre, Pageable pageable);

    public Optional<Livre> findByCote(String cote);

    public Page<Livre> findByAnneePublication(Date anneePub, Pageable pageable);

    public Page<Livre> findByMaisonEdition(String maisonEdit, Pageable pageable);

    public Page<Livre> findByTitreLikeAndLangue(String titre, Langue langue, Pageable pageable);

    public Page<Livre> findByLangue(Langue langue, Pageable pageable);

}
