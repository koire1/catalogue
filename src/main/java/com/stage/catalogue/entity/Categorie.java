package com.stage.catalogue.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author cellule
 */
@Entity
@Data
public class Categorie implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCategorie;
    
    @Column(name = "nomcategorie", nullable = false)
    private String nomCategorie;
    
    @OneToMany(mappedBy = "categorie")
    private List<Livre> livre;
}
