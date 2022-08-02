package com.stage.catalogue.dao;

import org.springframework.stereotype.Repository;

import com.stage.catalogue.entity.Departement;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author cellule
 */
@Repository
public interface DepartementDao extends JpaRepository<Departement, Integer>{
    public Page<Departement> findDepartementByNomDepart(String nomDepart, Pageable pageable);
        public Optional<Departement> findDepartementByIdDepart(int idDepart);
        public Departement findByNomDepart(String nomDepart);
        public Page<Departement> findAllDepartement(Pageable pageable);
}
