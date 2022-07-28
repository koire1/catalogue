package com.stage.catalogue.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author cellule
 */
@Entity
@Data
public class Departement implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDepart;
    
    @Column(name = "nomdepart", nullable = false)
    private String nomDepart;
    
    @OneToMany(mappedBy = "departement")
    private List<Specialite> specialite;
    
    
    @OneToMany(mappedBy = "departement")
    private List<Memoire> memoire;
}
