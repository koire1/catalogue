package com.stage.catalogue.entity;

import com.sun.istack.NotNull;
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
public class Livre implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLivre;
    
    @Column(name = "titre", nullable = false)
    private String titre;
    
    @Column(name = "nbrepage", nullable = false)
    private int nbrePage;
    
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
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
    
    @ManyToMany
    @JoinTable(name = "auteur_livre",
               joinColumns = @JoinColumn(name = "idLivre"),
               inverseJoinColumns = @JoinColumn(name = "idAuteur"))
    private List<Auteur> auteurs;
    
    
    //@NotNull
    @ManyToOne
    @JoinColumn(name="idCategorie")
    private Categorie categorie;
   
}
