package com.stage.catalogue.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author cellule
 */
@Entity
@Data
@Table(name = "diplome")
public class Diplome implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name="code", nullable = false, unique = true)
    private String code;
    
    @NotNull
    @Column(name="intitule", nullable = false)
    private String intitule;
}
