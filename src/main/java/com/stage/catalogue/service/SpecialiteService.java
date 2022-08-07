package com.stage.catalogue.service;

import com.stage.catalogue.dao.SpecialiteDao;
import com.stage.catalogue.entity.Specialite;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cellule
 */
@Service
public class SpecialiteService {
    
    @Autowired
    private SpecialiteDao specialiteDao;
    
    public Specialite addSpecialite(Specialite specialite) {
        return specialiteDao.save(specialite);
    }
    
    public Specialite getSpecialiteByNomSpecialite(String code) {
        return specialiteDao.findByCode(code).orElse(null);
    }
    
    public Specialite getSpecialiteById(long idSpecialite) {
        return specialiteDao.findById(idSpecialite).orElse(null);
    }
    
    public List<Specialite> getAll() {
        return specialiteDao.findAll();
    }
    
    public Specialite editSpecialiteById(Specialite specialite) {
        Optional<Specialite> oSpecialite = specialiteDao.findById(specialite.getId());
        if (oSpecialite.isPresent()) {
            Specialite existingSpecialite = oSpecialite.get();
            existingSpecialite.setDepartement(specialite.getDepartement());
            existingSpecialite.setCode(specialite.getCode());
            existingSpecialite.setIntitule(specialite.getIntitule());
            return specialiteDao.save(existingSpecialite);
        }
        return null;
    }
    
    public void deleteSpecialiteById(long idSpecialite) {
        specialiteDao.deleteById(idSpecialite);
    }
}
