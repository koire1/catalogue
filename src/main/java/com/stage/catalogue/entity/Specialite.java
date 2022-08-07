package com.stage.catalogue.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author cellule
 */
@Entity
@Data
@Table(name = "specialite",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"code", "departement_id"})
        })
public class Specialite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "intitule", nullable = false)
    private String intitule;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "departement_id", nullable = false)
    private Departement departement;
}
