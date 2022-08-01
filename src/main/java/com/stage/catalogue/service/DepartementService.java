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
    
    public Departement getDepartementByNomDepart(String nomDepart){
        return departement.findDepartementByNomDepart(nomDepart);
    }
    
    public List<Departement> getAllDepartement(){
        return departement.findAll();
    }
    
    public Departement editDepartement(Departement depart, int idDepart){
        Departement existingDepartement=departement.findById(idDepart).orElse(null);
                    existingDepartement.setNomDepart(depart.getNomDepart());
        return departement.save(existingDepartement);
    }
    
    public void dropDepartementByIdDepart(int idDepart){
        departement.deleteById(idDepart);
    }
    
}
