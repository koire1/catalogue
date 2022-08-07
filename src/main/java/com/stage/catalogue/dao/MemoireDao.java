package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Diplome;
import com.stage.catalogue.entity.Memoire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cellule
 */
@Repository
public interface MemoireDao extends JpaRepository<Memoire, Long> {

    public Page<Memoire> findByTitreLike(String titre, Pageable pageable);

    public Page<Memoire> findByMotsCles(String motCle, Pageable pageable);

    public Page<Memoire> findByDiplome(Diplome cycle, Pageable pageable);

    public Page<Memoire> findByAnnee(String anneeValid, Pageable pageable);
}
