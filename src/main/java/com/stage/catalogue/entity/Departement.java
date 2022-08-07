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
@Table(name = "departement")
public class Departement implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "code", unique = true, nullable = false)
    private String code;
    
    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;
    
    @JsonIgnore
    @XmlTransient
    @OneToMany(mappedBy = "departement")
    private List<Specialite> specialites;
    
}
