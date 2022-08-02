package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Specialite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
/**
 *
 * @author cellule
 */
@Repository
public interface SpecialiteDao extends JpaRepository<Specialite, Integer>{
    public ResponseEntity<Specialite> findSpecialiteByNomSpecialite(String nomSpecialite);
    public ResponseEntity<Specialite> findSpecialiteByIdSpecialite(int idSpecialite);
    public Page<Specialite> findAllSpecialite(Pageable pageable);
}
