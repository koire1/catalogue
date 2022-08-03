package com.stage.catalogue.service;

import com.stage.catalogue.dao.DepartementDao;
import com.stage.catalogue.entity.Departement;
import java.util.List;
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
    private DepartementDao departement;
    
    public Departement addDepartement(Departement depart){
        return departement.save(depart);
    }
    
    public Departement getDepartementById(int idDepart){
         return departement.findDepartementByIdDepart(idDepart);
    }
    
    public Page<Departement> getDepartementByNom(String nomDepart, int page, int size){
        return departement.findDepartementByNomDepart(nomDepart, PageRequest.of(page, size));
    }
    
    public List<Departement> getAll(){
        return departement.findAll();
    }
    
    public Departement editDepartement(Departement depart, int idDepart){
        Departement existingDepartement = departement.findDepartementByIdDepart(idDepart);
                    existingDepartement.setNomDepart(depart.getNomDepart());
                    existingDepartement.setSpecialite(depart.getSpecialite());
        return departement.save(existingDepartement);
    }
    
    public void dropDepartementById(int idDepart){
        departement.deleteById(idDepart);
    }
    
}
