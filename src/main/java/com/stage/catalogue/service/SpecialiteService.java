package com.stage.catalogue.service;

import com.stage.catalogue.dao.SpecialiteDao;
import com.stage.catalogue.entity.Specialite;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
/**
 *
 * @author cellule
 */
@Service
public class SpecialiteService {
    @Autowired
    private SpecialiteDao specialite;
    
    public ResponseEntity<Specialite> addSpecialite(Specialite special){
        Specialite spe = specialite.save(special);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                       .path("{/id}")
                       .buildAndExpand(spe.getIdSpecialite())
                       .toUri();
        return ResponseEntity.created(location).body(spe);
    }
    
    public ResponseEntity<Specialite> getSpecialiteByNomSpecialite(String nomSpecialite){
        return specialite.findSpecialiteByNomSpecialite(nomSpecialite);
    }
    
    public ResponseEntity<Specialite> getSpecialiteById(int idSpecialite){
        return specialite.findSpecialiteByIdSpecialite(idSpecialite);
    }
    
    public Page<Specialite> findAll(int page, int size){
        return specialite.findAllSpecialite(PageRequest.of(page, size));
    }
    public ResponseEntity<Specialite> editSpecialiteById(Specialite special, int idSpecialite){
        return specialite.findById(idSpecialite).map(
               c ->{
                   c.setNomSpecialite(special.getNomSpecialite());
                   return ResponseEntity.ok(specialite.save(c));
               }).orElse(
                       ResponseEntity.notFound().build()
               );
    }
    
    public void deleteSpecialiteById(int idSpecialite){
        specialite.deleteById(idSpecialite);
    }
}
