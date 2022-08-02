package com.stage.catalogue.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author cellule
 */
@Entity
@Data
public class Specialite implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSpecialite;
    
    @Column(name = "nomspecialite", nullable = false)
    private String nomSpecialite;
    
    @ManyToOne
    @JoinColumn(name = "idDepart", nullable = false)
    private Departement departement;
}
