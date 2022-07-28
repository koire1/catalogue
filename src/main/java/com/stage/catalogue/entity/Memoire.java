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
public class Memoire implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMemoire;
    
    @Column(name = "anneevalid", nullable = false)
    private String anneeValid;
    
    @Column(name = "lientelecharge", nullable = false)
    private String lienTelecharge;
    
    @Column(name = "titre", nullable = false)
    private String titre;
    
    @Column(name = "motcle", nullable = false)
    private String motCle;
    
    @Column(name = "cycle", nullable = false)
    private Cycle cycle;
    
    @Column(name = "nbretelechargememoire")
    private int nbreTelechargeMemoire;
    
    @Column(name="nbrevuememoire")
    private int nbreVueMemoire;
    
    @ManyToOne
    @JoinColumn(name = "idDepart", nullable = false)
    private Departement departement;
    
    @ManyToOne
    @JoinColumn(name="idEtudiant", nullable = false)
    private Etudiant etudiant;
    
}
