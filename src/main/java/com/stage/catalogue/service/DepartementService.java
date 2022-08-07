package com.stage.catalogue.service;

import com.stage.catalogue.dao.DepartementDao;
import com.stage.catalogue.dao.SpecialiteDao;
import com.stage.catalogue.entity.Departement;
import com.stage.catalogue.entity.Specialite;
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
public class DepartementService {
    
    @Autowired
    private DepartementDao departementDao;
    
    public Departement addDepartement(Departement departement) {
        return departementDao.save(departement);
    }
    
    public Departement getDepartementById(long idDepart) {
        return departementDao.findById(idDepart).orElse(null);
    }
    
    public Page<Departement> getDepartementByNom(String nomDepart, int page, int size) {
        return departementDao.findByNomLike(nomDepart, PageRequest.of(page, size));
    }
    
    public List<Specialite> getSpecialite(long idDepart) {
        Optional<Departement> oDepartement = departementDao.findById(idDepart);
        if (oDepartement.isPresent()) {
            return oDepartement.get().getSpecialites();
        }
        return null;
    }
    
    public List<Departement> getAll() {
        return departementDao.findAll();
    }
    
    public Departement editDepartement(Departement departement) {
        Optional<Departement> oDepartement = departementDao.findById(departement.getId());
        if (oDepartement.isPresent()) {
            Departement existingDepartement = oDepartement.get();
            existingDepartement.setNom(departement.getNom());
            existingDepartement.setSpecialites(departement.getSpecialites());
            existingDepartement.setCode(departement.getCode());
            return departementDao.save(existingDepartement);
        }
        return null;
    }
    
    public void dropDepartementById(long idDepart) {
        departementDao.deleteById(idDepart);
    }
    
}
