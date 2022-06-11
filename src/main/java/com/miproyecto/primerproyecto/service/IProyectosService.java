package com.miproyecto.primerproyecto.service;

import com.miproyecto.primerproyecto.model.Proyectos;
import java.util.List;


public interface IProyectosService {
    
    public List<Proyectos> verProyectos();
    public void crearProyectos(Proyectos proy);
    public void borrarProyectos(Long id);
    public Proyectos buscarProyectos(Long id);
    public Proyectos editarProyectos(Proyectos proy);
    
}