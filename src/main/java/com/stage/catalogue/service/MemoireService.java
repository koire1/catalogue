package com.stage.catalogue.service;

import com.stage.catalogue.dao.DepartementDao;
import com.stage.catalogue.dao.EtudiantDao;
import com.stage.catalogue.dao.MemoireDao;
import com.stage.catalogue.entity.Cycle;
import com.stage.catalogue.entity.Etudiant;
import com.stage.catalogue.entity.Departement;
import com.stage.catalogue.entity.Memoire;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/**
 *
 * @author cellule
 */
@Service
public class MemoireService {
    @Autowired
    private MemoireDao memoire;
    @Autowired
    private DepartementDao departement;
    @Autowired
    private EtudiantDao etudiant;
    
    public ResponseEntity<Memoire> addMemoire(Memoire memo){
        Memoire me = memoire.save(memo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/id")
                        .buildAndExpand(me.getIdMemoire())
                        .toUri();
        return ResponseEntity.created(location).body(me);
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
    
    public ResponseEntity<Memoire> editMemoireById(Memoire memo, int idMemoire){
        return memoire.findById(idMemoire).map(
                c ->{
                    c.setAnneeValid(memo.getAnneeValid());
                    c.setCycle(memo.getCycle());
                    c.setMotCle(memo.getMotCle());
                    c.setLienTelecharge(memo.getLienTelecharge());
                    c.setNbreTelechargeMemoire(memo.getNbreTelechargeMemoire());
                    c.setNbreVueMemoire(memo.getNbreVueMemoire());
                    c.setTitre(memo.getTitre());
                    Etudiant nom = etudiant.findByNomEtudiant(memo.getEtudiant().getNomEtudiant());
                    c.setEtudiant(nom);
                    Departement nomDep = departement.findByNomDepart(memo.getDepartement().getNomDepart());
                    c.setDepartement(nomDep);
                    return ResponseEntity.ok(memoire.save(c));
                }
        ).orElse(ResponseEntity.notFound().build());
    }
    
    public void dropMemoireById(int idMemoire){
        memoire.deleteById(idMemoire);
    }
}
