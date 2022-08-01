package com.stage.catalogue.service;

import com.stage.catalogue.dao.MemoireDao;
import com.stage.catalogue.entity.Cycle;
import com.stage.catalogue.entity.Memoire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
/**
 *
 * @author cellule
 */
@Service
public class MemoireService {
    @Autowired
    private MemoireDao memoire;
    
    public Memoire addMemoire(Memoire memo){
        return memoire.save(memo);
    }
    
    public Page<Memoire> getMemoireByAnneeValid(String anneeValid, Pageable pageable){
        return memoire.findMemoireByAnneeValid(anneeValid, pageable);
    }
    
    public Page<Memoire> getMemoireByTitre(String titre, Pageable pageable){
        return memoire.findMemoireByTitre(titre, pageable);
    }
    
    public Page<Memoire> getMemoireByMotCle(String motCle, Pageable pageable){
        return memoire.findMemoireByMotCle(motCle, pageable);
    }
    
    public Page<Memoire> getMemoireByCycle(Cycle cycle, Pageable pageable){
        return memoire.findMemoireByCycle(cycle, pageable);
    }
    
    public Memoire editMemoireById(Memoire memo, int idMemoire){
        Memoire existingMemoire=memoire.findById(idMemoire).orElse(null);
                existingMemoire.setAnneeValid(memo.getAnneeValid());
                existingMemoire.setCycle(memo.getCycle());
                existingMemoire.setLienTelecharge(memo.getLienTelecharge());
                existingMemoire.setMotCle(memo.getMotCle());
                existingMemoire.setTitre(memo.getTitre());
        return memoire.save(existingMemoire);
    }
    
    public void dropMemoireById(int idMemoire){
        memoire.deleteById(idMemoire);
    }
}
