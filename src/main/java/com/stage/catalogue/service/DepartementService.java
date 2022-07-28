package com.stage.catalogue.service;

import com.stage.catalogue.dao.DepartementDao;
import com.stage.catalogue.entity.Departement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author cellule
 */
@Service
public class DepartementService {
    @Autowired
    private DepartementDao departement;
    
    public Departement addDepartement(Departement depart){
        return departement.save(depart);
    }
    
    public List<Departement> getDepartement(String nomDepart){
        return departement.findDepartementByNomDepart(nomDepart);
    }
    
    public Departement editDepartement(Departement depart){
        Departement existingDepartement=departement.findById(depart.getIdDepart()).orElse(null);
                    existingDepartement.setNomDepart(depart.getNomDepart());
        return departement.save(existingDepartement);
    }
}
