package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Diplome;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vincent
 */
@Repository
public interface DiplomeDao extends JpaRepository<Diplome, Long>{
    
    public Optional<Diplome> findByCode(String code);
}
