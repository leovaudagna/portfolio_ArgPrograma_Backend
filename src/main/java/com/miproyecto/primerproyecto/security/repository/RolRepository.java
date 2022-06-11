
package com.miproyecto.primerproyecto.security.repository;

import com.miproyecto.primerproyecto.security.entity.Rol;
import com.miproyecto.primerproyecto.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    
    Optional<Rol> findByRolNombre(RolNombre rolNombre);    
    
    
}
