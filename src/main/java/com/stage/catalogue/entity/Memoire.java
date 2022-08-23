package com.stage.catalogue.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import lombok.Data;

/**
 *
 * @author cellule
 */
@Entity
@Data
//@Table(name = "memoire")
public class Memoire implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @NotNull
    @PastOrPresent
    @Column(nullable = false, name = "annee")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date annee;
    
    @NotNull
    @Column(name = "titre", nullable = false)
    private String titre;
    
    @ElementCollection
    @CollectionTable(name = "mots_cles")
    private List<String> motsCles;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "diplome_id")
    private Diplome diplome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "details_id")
    private Details details;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "departement_id", nullable = false)
    private Departement departement;
    
    @ManyToMany
    @JoinTable(name = "etudiant_memoire",
               joinColumns = @JoinColumn(name = "memoire_id"),
               inverseJoinColumns = @JoinColumn(name = "etudiant_id"))
    private List<Etudiant> etudiants;
    
}
