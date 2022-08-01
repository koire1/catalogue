package com.stage.catalogue.dao;

import org.springframework.stereotype.Repository;

import com.stage.catalogue.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author cellule
 */
@Repository
public interface DepartementDao extends JpaRepository<Departement, Integer>{
    public Departement findDepartementByNomDepart(String nomDepart);
}
