package com.stage.catalogue.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author cellule
 */
@Entity
@Data
public class Livre implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLivre;
    
    @Column(name = "titre", nullable = false)
    private String titre;
    
    @Column(name = "nbrepage", nullable = false)
    private int nbrePage;
    
    @Column(name = "anneepub", nullable = false)
    private Date anneePub;
    
    @Column(name = "langue", nullable = false)
    private Langue langue;
    
    @Column(name = "cote", nullable = false)
    private String cote;
    
    @Column(name = "maisonedit", nullable = false)
    private String maisonEdit;
    
    @Column(name = "isbn", nullable = false)
    private String isbn;
    
    @Column(name = "image", nullable = false)
    private String image;
    
    @Column(name="nbrevuelivre")
    private int nbreVueLivre;
    
    @ManyToOne
    @JoinColumn(name="idAuteur", nullable = false)
    private Auteur auteur;
    
    @ManyToOne
    @JoinColumn(name="idCategorie", nullable = false)
    private Categorie categorie;
}
