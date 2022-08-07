package com.stage.catalogue.service;

import com.stage.catalogue.dao.MemoireDao;
import com.stage.catalogue.entity.Diplome;
import com.stage.catalogue.entity.Memoire;
import java.util.Optional;
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
    private MemoireDao memoireDao;

    public Memoire addMemoire(Memoire memoire) {
        return memoireDao.save(memoire);
    }

    public Page<Memoire> findAll(int page, int size) {
        return memoireDao.findAll(PageRequest.of(page, size));
    }

    public Page<Memoire> getMemoireByAnneeValid(String anneeValid, int page, int size) {
        return memoireDao.findByAnnee(anneeValid, PageRequest.of(page, size));
    }

    public Page<Memoire> getMemoireByTitre(String titre, int page, int size) {
        return memoireDao.findByTitreLike(titre, PageRequest.of(page, size));
    }

    public Page<Memoire> getMemoireByMotCle(String motCle, int page, int size) {
        return memoireDao.findByMotsCles(motCle, PageRequest.of(page, size));
    }

    public Page<Memoire> getMemoireByCycle(Diplome cycle, int page, int size) {
        return memoireDao.findByDiplome(cycle, PageRequest.of(page, size));
    }

    public Memoire editMemoireById(Memoire memoire) {
        Optional<Memoire> oMemoire = memoireDao.findById(memoire.getId());
        if (oMemoire.isPresent()) {
            Memoire existingMemoire = oMemoire.get();
            existingMemoire.setAnnee(memoire.getAnnee());
            existingMemoire.setDiplome(memoire.getDiplome());
            existingMemoire.setDepartement(memoire.getDepartement());
            existingMemoire.setEtudiants(memoire.getEtudiants());
            existingMemoire.setLienTelecharge(memoire.getLienTelecharge());
            existingMemoire.setMotsCles(memoire.getMotsCles());
            existingMemoire.setNombreTelechargements(memoire.getNombreTelechargements());
            existingMemoire.setNombreVues(memoire.getNombreVues());
            existingMemoire.setTitre(memoire.getTitre());
            return memoireDao.save(existingMemoire);
        }
        return null;
    }

    public void dropMemoireById(long idMemoire) {
        memoireDao.deleteById(idMemoire);
    }
}
