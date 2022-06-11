
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
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Educacion implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    private String titulo;
    private String establecimiento;
    private String fechaInic_ed;
    private String fechaFin_ed;
    private String logoUrl;



    public Educacion(){} 
    
    public Educacion(Long id, String titulo, String establecimiento, String fechaInic_ed, String fechaFin_ed, String logoUrl) {
        this.id = id;
        this.titulo = titulo;
        this.establecimiento = establecimiento;
        this.fechaInic_ed = fechaInic_ed;
        this.fechaFin_ed = fechaFin_ed;
        this.logoUrl = logoUrl;
    } 
    
    
}
