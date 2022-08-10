package com.stage.catalogue.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author cellule
 */
@Entity
@Data
@Table(name = "utilisateur")
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    
    @JsonIgnore
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;
    
    @NotNull
    @Column(name = "role", nullable = false)
    private Role role;
    
    @NotNull
    @Column(name = "nom", nullable = false)
    private String name;
    
    @Email
    @NotNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @JsonIgnore
    @Column(name= "enabled", columnDefinition = "tinyint(1) default 0")
    private boolean enabled;
    
    @JsonIgnore
    @Column(name= "locked", columnDefinition = "tinyint(1) default 0")
    private boolean locked;

}
