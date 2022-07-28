package com.stage.catalogue.dao;

import com.stage.catalogue.entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author cellule
 */
@Repository
public interface SpecialiteDao extends JpaRepository<Specialite, Integer>{
    public Specialite findSpecialiteByNomSpecialite(String nomSpecialite);
}
