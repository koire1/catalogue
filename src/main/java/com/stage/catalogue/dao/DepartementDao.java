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
public interface DepartementDao extends JpaRepository<Departement, Long> {

    public Page<Departement> findByNomLike(String nom, Pageable pageable);

    public Optional<Departement> findByCode(String code);
}
