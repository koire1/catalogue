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
//@Table(name = "categorie")
public class Categorie implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "nom", nullable = false, unique = true)
    private String nom;
    
    @JsonIgnore
    @XmlTransient
    @OneToMany(mappedBy = "categorie")
    private List<Livre> livres;
}
