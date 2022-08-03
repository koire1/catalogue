package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Cycle;
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
public interface MemoireDao extends JpaRepository<Memoire, Integer>{
    public Page<Memoire> findMemoireByTitre(String titre, Pageable pageable);
    public Page<Memoire> findMemoireByMotCle(String motCle, Pageable pageable);
    public Page<Memoire> findMemoireByCycle(Cycle cycle, Pageable pageable);
    public Page<Memoire> findMemoireByAnneeValid(String anneeValid, Pageable pageable);
    public Memoire findMemoireByIdMemoire(Integer idMemoire);
}
