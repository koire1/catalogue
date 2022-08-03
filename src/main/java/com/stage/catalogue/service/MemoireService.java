package com.stage.catalogue.service;

import com.stage.catalogue.dao.MemoireDao;
import com.stage.catalogue.entity.Cycle;
import com.stage.catalogue.entity.Memoire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    
    public Page<Memoire> findAll(int page, int size){
        return memoire.findAll(PageRequest.of(page, size));
    }
    
    public Page<Memoire> getMemoireByAnneeValid(String anneeValid, int page, int size){
        return memoire.findMemoireByAnneeValid(anneeValid, PageRequest.of(page, size));
    }
    
    public Page<Memoire> getMemoireByTitre(String titre, int page, int size){
        return memoire.findMemoireByTitre(titre, PageRequest.of(page, size));
    }
    
    public Page<Memoire> getMemoireByMotCle(String motCle, int page, int size){
        return memoire.findMemoireByMotCle(motCle, PageRequest.of(page, size));
    }
    
    public Page<Memoire> getMemoireByCycle(Cycle cycle, int page, int size){
        return memoire.findMemoireByCycle(cycle, PageRequest.of(page, size));
    }
    
    public Memoire editMemoireById(Memoire memo, int idMemoire){
        Memoire existingMemoire = memoire.findMemoireByIdMemoire(idMemoire);
                existingMemoire.setAnneeValid(memo.getAnneeValid());
                existingMemoire.setCycle(memo.getCycle());
                existingMemoire.setDepartement(memo.getDepartement());
                existingMemoire.setEtudiant(memo.getEtudiant());
                existingMemoire.setLienTelecharge(memo.getLienTelecharge());
                existingMemoire.setMotCle(memo.getMotCle());
                existingMemoire.setNbreTelechargeMemoire(memo.getNbreTelechargeMemoire());
                existingMemoire.setNbreVueMemoire(memo.getNbreVueMemoire());
                existingMemoire.setTitre(memo.getTitre());
        return memoire.save(existingMemoire);
    }
    
    public void dropMemoireById(int idMemoire){
        memoire.deleteById(idMemoire);
    }
}
