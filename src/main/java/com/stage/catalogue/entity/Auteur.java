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
public class Auteur implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuteur;
    
    @Column(name = "nomauteur", nullable = false)
    private String nomAuteur;
    
    @JsonIgnore
    @XmlTransient
    @ManyToMany
    @JoinTable(name = "auteur_livre",
               joinColumns = @JoinColumn(name = "idAuteur"),
               inverseJoinColumns = @JoinColumn(name = "idLivre"))
    private List<Livre> livres;
}
