package com.stage.catalogue.service;

import com.stage.catalogue.dao.MemoireDao;
import com.stage.catalogue.entity.Cycle;
import com.stage.catalogue.entity.Memoire;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    public List<Memoire> getMemoireByAnneeValid(String anneeValid){
        return memoire.findMemoireByAnneeValid(anneeValid);
    }
    
    public List<Memoire> getMemoireByTitre(String titre){
        return memoire.findMemoireByTitre(titre);
    }
    
    public List<Memoire> getMemoireByMotCle(String motCle){
        return memoire.findMemoireByMotCle(motCle);
    }
    
    public List<Memoire> getMemoireByCycle(Cycle cycle){
        return memoire.findMemoireByCycle(cycle);
    }
    
    public Memoire editMemoire(Memoire memo){
        Memoire existingMemoire=memoire.findById(memo.getIdMemoire()).orElse(null);
                existingMemoire.setAnneeValid(memo.getAnneeValid());
                existingMemoire.setCycle(memo.getCycle());
                existingMemoire.setLienTelecharge(memo.getLienTelecharge());
                existingMemoire.setMotCle(memo.getMotCle());
                existingMemoire.setTitre(memo.getTitre());
        return memoire.save(existingMemoire);
    }
}
