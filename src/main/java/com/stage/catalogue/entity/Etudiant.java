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
@Table(name = "etudiant")
public class Etudiant implements Serializable{
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nom", nullable = false)
    private String nom;
    
    @Column(name = "matricule", nullable = false, unique = true)
    private String matricule;
    
    @JsonIgnore
    @XmlTransient
    @ManyToMany
    @JoinTable(name = "etudiant_memoire",
               joinColumns = @JoinColumn(name = "idEtudiant"),
               inverseJoinColumns = @JoinColumn(name = "idMemoire"))
    private List<Memoire> memoires;
    
}
