package com.stage.catalogue.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

/**
 *
 * @author cellule
 */
@Entity
@Data
public class Etudiant implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;
    
    @Column(name = "nometudiant", nullable = false)
    private String nomEtudiant;
    
    @Column(name = "prenometudiant", nullable = false)
    private String prenomEtudiant;
    
    @Column(name = "matricule", nullable = false)
    private String matricule;
    
    @JsonIgnore
    @XmlTransient
    @ManyToMany
    @JoinTable(name = "etudiant_memoire",
               joinColumns = @JoinColumn(name = "idEtudiant"),
               inverseJoinColumns = @JoinColumn(name = "idMemoire"))
    private List<Memoire> memoires;
    
}
