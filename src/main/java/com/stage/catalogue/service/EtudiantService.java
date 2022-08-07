package com.stage.catalogue.service;

import com.stage.catalogue.dao.EtudiantDao;
import com.stage.catalogue.entity.Etudiant;
import java.util.List;
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
public class EtudiantService {

    @Autowired
    private EtudiantDao etudiantDao;

    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantDao.save(etudiant);
    }

    public Page<Etudiant> getEtudiantByNom(String nomEtudiant, int page, int size) {
        return etudiantDao.findByNomLike(nomEtudiant, PageRequest.of(page, size));
    }

    public Etudiant getEtudiantByMatricule(String matricule) {
        return etudiantDao.findByMatricule(matricule).orElse(null);
    }

    public List<Etudiant> getAll() {
        return etudiantDao.findAll();
    }

    public Etudiant editEtudiantById(Etudiant etudiant) {
        Optional<Etudiant> oEtudiant = etudiantDao.findById(etudiant.getId());
        if (oEtudiant.isPresent()) {
            Etudiant existingEtudiant = oEtudiant.get();
            existingEtudiant.setMatricule(etudiant.getMatricule());
            existingEtudiant.setNom(etudiant.getNom());
            return etudiantDao.save(existingEtudiant);
        }
        return null;
    }

    public void dropEtudiantById(long idEtudiant) {
        etudiantDao.deleteById(idEtudiant);
    }
}
