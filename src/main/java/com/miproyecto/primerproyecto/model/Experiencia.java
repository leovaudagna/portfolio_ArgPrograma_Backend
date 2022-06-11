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
public class Experiencia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String empresa;
    private String rubro;
    private String descripcion;
    private String fechaInic;
    private String fechaFin;
    private String lugar;
    
    public Experiencia(){
    }
    
    public Experiencia(Long id, String empresa, String rubro, String descripcion, String fechaInic, String fechaFin, String lugar) {
        this.id = id;
        this.empresa = empresa;
        this.rubro = rubro;
        this.descripcion = descripcion;
        this.fechaInic = fechaInic;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
    }
    
    
    
    
}
