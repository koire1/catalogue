package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Specialite;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author cellule
 */
@Repository
public interface SpecialiteDao extends JpaRepository<Specialite, Long>{
    
    public Optional<Specialite> findByCode(String code);
    
    public Page<Specialite> findByIntitule(String intitule, Pageable page);
}
