package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Cycle;
import com.stage.catalogue.entity.Memoire;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author cellule
 */
@Repository
public interface MemoireDao extends JpaRepository<Memoire, Integer>{
    public List<Memoire> findMemoireByTitre(String titre);
    public List<Memoire> findMemoireByMotCle(String motCle);
    public List<Memoire> findMemoireByCycle(Cycle cycle);
    public List<Memoire> findMemoireByAnneeValid(String anneeValid);
}
