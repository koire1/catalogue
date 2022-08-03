package com.stage.catalogue.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author cellule
 */
@Entity
@Data
public class Utilisateur implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtilisateur;
    
    @Column(name = "login", nullable = false)
    private Role login;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "nom", nullable = false)
    private String nom;

}
