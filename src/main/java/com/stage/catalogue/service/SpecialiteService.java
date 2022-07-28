package com.stage.catalogue.service;

import com.stage.catalogue.dao.SpecialiteDao;
import com.stage.catalogue.entity.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author cellule
 */
@Service
public class SpecialiteService {
    @Autowired
    private SpecialiteDao specialite;
    
    public Specialite addSpecialite(Specialite special){
        return specialite.save(special);
    }
    
    public Specialite getSpecialiteByNomSpecialite(String nomSpecialite){
        return specialite.findSpecialiteByNomSpecialite(nomSpecialite);
    }
    
    public Specialite editSpecialite(Specialite special){
        Specialite existingSpecialite=specialite.findById(special.getIdSpecialite()).orElse(null);
                   existingSpecialite.setNomSpecialite(special.getNomSpecialite());
        return specialite.save(existingSpecialite);
    }
}
