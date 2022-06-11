package com.miproyecto.primerproyecto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nombre;
    private String apellido;
    private String titulo;
    private String fechaNac;
    private String acercaDe;
    private String urlFoto;
    private String correoElectronico;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn( name = "id_persona", referencedColumnName = "id")
    private List<Educacion> educacion = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "id_persona", referencedColumnName = "id")
    private List<Experiencia> experiencia = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "id_persona", referencedColumnName = "id")
    private List<RedesSociales> redes = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "id_persona", referencedColumnName = "id")
    private List<Proyectos> proyectos = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "id_persona", referencedColumnName = "id")
    private List<HardSkills> hskills = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn( name = "id_persona", referencedColumnName = "id")
    private List<SoftSkills> sskills = new ArrayList<>();
    
    
    public Persona() {
    }
    

    public Persona(String nombre, String apellido, String titulo, String fechaNac, String acercaDe, String urlFoto, String correoElectronico, List<Educacion> educacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.fechaNac = fechaNac;
        this.acercaDe = acercaDe;
        this.urlFoto = urlFoto;
        this.correoElectronico = correoElectronico;
    }
    
    
}
