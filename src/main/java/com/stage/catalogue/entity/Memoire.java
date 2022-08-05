package com.stage.catalogue.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author cellule
 */
@Entity
@Data
public class Memoire implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMemoire;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date anneeValid;
    
    @Column(name = "lientelecharge", nullable = false)
    private String lienTelecharge;
    
    @Column(name = "titre", nullable = false)
    private String titre;
    
    @Column(name = "motcle", nullable = false)
    private String motCle;
    
    @Column(name = "parcours", nullable = false)
    private Cycle cycle;
    
    @Column(name = "nbretelechargememoire")
    private int nbreTelechargeMemoire;
    
    @Column(name="nbrevuememoire")
    private int nbreVueMemoire;
    
    @ManyToOne
    @JoinColumn(name = "idDepart", nullable = false)
    private Departement departement;
    
    @ManyToMany
    @JoinTable(name = "etudiant_memoire",
               joinColumns = @JoinColumn(name = "idMemoire"),
               inverseJoinColumns = @JoinColumn(name = "idEtudiant"))
    private List<Etudiant> etudiants;
    
}
