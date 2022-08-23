/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
//@Table(name = "details")
public class Details implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    
    @Column(name = "lientelecharge", nullable = false)
    private String lienTelecharge;
    
    @Column(name = "nbretelechargememoire")
    private int nombreTelechargements;
    
    @Column(name="nbrevuememoire")
    private int nombreVues;
    
}
