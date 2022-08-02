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
public class Auteur implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuteur;
    
    @Column(name = "nomauteur", nullable = false)
    private String nomAuteur;
    
    @OneToMany(mappedBy="auteur")
    private List<Livre> livre;
}
