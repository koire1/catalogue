package com.stage.catalogue.service;

import com.stage.catalogue.dao.DiplomeDao;
import com.stage.catalogue.entity.Diplome;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author vincent
 */
@Service
public class DiplomeService {
    
    @Autowired
    private DiplomeDao diplomeDao;
    
    public Diplome save(Diplome diplome){
        if(diplome.getId() == null){
            return diplomeDao.save(diplome);
        }else{
            Optional<Diplome> oDiplome = diplomeDao.findById(diplome.getId());
            if(oDiplome.isPresent()){
                Diplome existingDiplome = oDiplome.get();
                existingDiplome.setCode(diplome.getCode());
                existingDiplome.setIntitule(diplome.getIntitule());
                return diplomeDao.save(existingDiplome);
            }
        }
        return null;
    }
    
    public void delete(long id){
        diplomeDao.deleteById(id);
    }
    
    public Page<Diplome> findAll(int page, int size){
        return diplomeDao.findAll(PageRequest.of(page, size));
    }
    
    public Optional<Diplome> findById(long id){
        return diplomeDao.findById(id);
    }
}
