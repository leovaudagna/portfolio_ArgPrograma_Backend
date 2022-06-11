
package com.miproyecto.primerproyecto.repository;

import com.miproyecto.primerproyecto.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository <Educacion, Long> {
    
}
