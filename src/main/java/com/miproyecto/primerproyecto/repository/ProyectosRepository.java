package com.miproyecto.primerproyecto.repository;

import com.miproyecto.primerproyecto.model.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProyectosRepository extends JpaRepository<Proyectos, Long> {
    
}
