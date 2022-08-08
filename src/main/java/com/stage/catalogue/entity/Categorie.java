package com.stage.catalogue.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author cellule
 */
@Entity
@Data
@Table(name = "categorie")
public class Categorie implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "nom", nullable = false, unique = true)
    private String nom;
}
