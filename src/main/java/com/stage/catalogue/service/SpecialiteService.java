package com.stage.catalogue.service;

import com.stage.catalogue.dao.SpecialiteDao;
import com.stage.catalogue.entity.Specialite;
import java.util.List;
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
        special.setDepartement(special.getDepartement());
        return specialite.save(special);
    }
    
    public Specialite getSpecialiteByNomSpecialite(String nomSpecialite){
        return specialite.findSpecialiteByNomSpecialite(nomSpecialite);
    }
    
    public Specialite getSpecialiteById(int idSpecialite){
        return specialite.findSpecialiteByIdSpecialite(idSpecialite);
    }
    
    public List<Specialite> getAll(){
        return specialite.findAll();
    }
    public Specialite editSpecialiteById(Specialite special, int idSpecialite){
        Specialite existingSpecialite = specialite.findSpecialiteByIdSpecialite(idSpecialite);
                   existingSpecialite.setDepartement(special.getDepartement());
                   existingSpecialite.setNomSpecialite(special.getNomSpecialite());
        return specialite.save(existingSpecialite);
    }
    
    public void deleteSpecialiteById(int idSpecialite){
        specialite.deleteById(idSpecialite);
    }
}
