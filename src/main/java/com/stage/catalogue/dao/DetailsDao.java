/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.stage.catalogue.dao;
import com.stage.catalogue.entity.Details;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cellule
 */
public interface DetailsDao extends JpaRepository<Details, Long>{
    
}
