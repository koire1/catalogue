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
public class Departement implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepart;
    
    @Column(name = "nomdepart", nullable = false)
    private String nomDepart;
    
    @JsonIgnore
    @XmlTransient
    @OneToMany(mappedBy = "departement")
    private List<Specialite> specialites;
    
    
    @JsonIgnore
    @XmlTransient
    @OneToMany(mappedBy = "departement")
    private List<Memoire> memoires;
}
