package com.stage.catalogue.service;

import com.stage.catalogue.dao.DepartementDao;
import com.stage.catalogue.entity.Departement;
import java.net.URI;
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
public class DepartementService {
    @Autowired
    private DepartementDao departement;
    
    public ResponseEntity<Departement> addDepartement(Departement depart){
        Departement dep = departement.save(depart);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(dep.getIdDepart())
                        .toUri();
        return ResponseEntity.created(location).body(dep);
        
    }
    
    public ResponseEntity<Departement> getDepartementById(int idDepart){
        Optional<Departement> dep = departement.findById(idDepart);
        if(dep.isPresent()){
            return ResponseEntity.ok(dep.get());
        }
        return ResponseEntity.notFound().build();
    }
    
    public Page<Departement> getDepartementByNom(String nomDepart, int page, int size){
        return departement.findDepartementByNomDepart(nomDepart, PageRequest.of(page, size));
    }
    
    public Page<Departement> getAllDepartement(int page, int size){
        return departement.findAllDepartement(PageRequest.of(page, size));
    }
    
    public ResponseEntity<Departement> editDepartement(Departement depart, int idDepart){
        return departement.findDepartementByIdDepart(idDepart).map(
                c -> {
                    c.setNomDepart(depart.getNomDepart());
                    c.setSpecialite(depart.getSpecialite());
                    return ResponseEntity.ok(departement.save(c));
                }   ).orElse(
                    ResponseEntity.notFound().build()
                    );
    }
    
    public void dropDepartementById(int idDepart){
        departement.deleteById(idDepart);
    }
    
}
