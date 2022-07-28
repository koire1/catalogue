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
public class Etudiant implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEtudiant;
    
    @Column(name = "nometudiant", nullable = false)
    private String nomEtudiant;
    
    @Column(name = "prenometudiant", nullable = false)
    private String prenomEtudiant;
    
    @Column(name = "matricule", nullable = false)
    private String matricule;
    
    @OneToMany(mappedBy="etudiant")
    private List<Memoire> memoire;
    
}
