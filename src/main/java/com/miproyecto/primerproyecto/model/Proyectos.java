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
public class Proyectos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreProy;
    private String descrProy;
    private String linkProy;
    private String imgProy;

    public Proyectos(){
    }
    
    public Proyectos(Long id, String nombreProy, String descrProy, String linkProy, String imgProy) {
        this.id = id;
        this.nombreProy = nombreProy;
        this.descrProy = descrProy;
        this.linkProy = linkProy;
        this.imgProy = imgProy;
    }     
    
}
