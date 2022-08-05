package com.stage.catalogue.service;

import com.stage.catalogue.dao.DepartementDao;
import com.stage.catalogue.dao.SpecialiteDao;
import com.stage.catalogue.entity.Departement;
import com.stage.catalogue.entity.Specialite;
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
    
    @Autowired
    private SpecialiteDao specialite;
    
    public Departement addDepartement(Departement depart){
        return departement.save(depart);
    }
    
    public Departement getDepartementById(int idDepart){
         return departement.findDepartementByIdDepart(idDepart);
    }
    
    public Page<Departement> getDepartementByNom(String nomDepart, int page, int size){
        return departement.findDepartementByNomDepart(nomDepart, PageRequest.of(page, size));
    }
    
    public List<Specialite> getSpecialite(int idDepart){
        Departement depart = departement.findDepartementByIdDepart(idDepart);
        return depart.getSpecialites();
    }
    
    public Specialite editSpecialite(int idDepart,int idSpecialite, Specialite special){
        Departement depart = departement.findDepartementByIdDepart(idDepart);
        Specialite spec = specialite.findSpecialiteByIdSpecialite(idSpecialite);
        spec.setNomSpecialite(special.getNomSpecialite());
        spec.setDepartement(depart);
        return specialite.save(spec);
                   
    }
    
    public void deleteSpecialite(int idSpecialite){
        specialite.deleteById(idSpecialite);
    }
    
    public Specialite addSpecialite(Specialite special){
        return specialite.save(special);
    }
    
    public List<Departement> getAll(){
        return departement.findAll();
    }
    
    public Departement editDepartement(Departement depart, int idDepart){
        Departement existingDepartement = departement.findDepartementByIdDepart(idDepart);
                    existingDepartement.setNomDepart(depart.getNomDepart());
                    existingDepartement.setSpecialites(depart.getSpecialites());
        return departement.save(existingDepartement);
    }
    
    public void dropDepartementById(int idDepart){
        departement.deleteById(idDepart);
    }
    
}
