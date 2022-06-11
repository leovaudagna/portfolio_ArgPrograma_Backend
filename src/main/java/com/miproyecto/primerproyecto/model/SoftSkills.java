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
public class SoftSkills implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreSSkill;
    private Long porcentajeSSkill;
    
    public SoftSkills(){}

    public SoftSkills(Long id, String nombreSSkill, Long porcentajeSSkill) {
        this.id = id;
        this.nombreSSkill = nombreSSkill;
        this.porcentajeSSkill = porcentajeSSkill;
    }   
    
    
}