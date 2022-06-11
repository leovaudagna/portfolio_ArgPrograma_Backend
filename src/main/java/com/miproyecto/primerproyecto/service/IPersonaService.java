package com.miproyecto.primerproyecto.service;

import com.miproyecto.primerproyecto.model.Persona;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> verPersonas();
    public void crearPersona(Persona per);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
    public Persona editarPersona(Persona persona);
    
    
}
