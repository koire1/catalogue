package com.stage.catalogue.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

/**
 *
 * @author cellule
 */
@Entity
@Data
@Table(name = "auteur")
public class Auteur implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;
    
    @JsonIgnore
    @XmlTransient
    @ManyToMany
    @JoinTable(name = "auteur_livre",
               joinColumns = @JoinColumn(name = "idAuteur"),
               inverseJoinColumns = @JoinColumn(name = "idLivre"))
    private List<Livre> livres;
}
