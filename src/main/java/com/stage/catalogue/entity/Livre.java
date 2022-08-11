package com.stage.catalogue.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author cellule
 */
@Entity
@Data
@Table(name = "livre")
public class Livre implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "titre", nullable = false)
    private String titre;
    
    @Column(name = "nombre_pages", nullable = false, columnDefinition = "int default 0")
    private int nombrePages;
    
    @Column(nullable = false, name = "annee_publication")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date anneePublication;
    
    @Column(name = "langue", nullable = false)
    private Langue langue;
    
    @Column(name = "cote")
    private String cote;
    
    @Column(name = "maison_edition", nullable = false)
    private String maisonEdition;
    
    @Column(name = "isbn", nullable = false)
    private String isbn;
    
    @Column(nullable = false, length = 1024*1024*30)
    byte[] file;
    
    @Transient
    String image;
    
    public void updateImage(){
        this.image = new String(file);
        this.file = null;
    }

    
    
    @ManyToMany
    @JoinTable(name = "livre_auteur",
               joinColumns = @JoinColumn(name = "livre_id"),
               inverseJoinColumns = @JoinColumn(name = "auteur_id"))
    private List<Auteur> auteurs;
    
    
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name="categorie_id")
    private Categorie categorie;
   
}
