
package com.miproyecto.primerproyecto.repository;

import com.miproyecto.primerproyecto.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Intermediario entre la base de datos y los metodos JPA */
// en los parámetros <> va: <clase a persistir, tipo de dato de su ID>
@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long> {
    
    /*
    public Object save(Long id);
    */
    
}