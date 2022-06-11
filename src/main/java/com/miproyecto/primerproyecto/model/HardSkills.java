package com.miproyecto.primerproyecto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class HardSkills implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreHSkill;
    private Long porcentajeHSkill;
    
    public HardSkills(){}

    public HardSkills(Long id, String nombreHSkill, Long porcentajeHSkill) {
        this.id = id;
        this.nombreHSkill = nombreHSkill;
        this.porcentajeHSkill = porcentajeHSkill;
    }   
    
    
}
