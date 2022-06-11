package com.miproyecto.primerproyecto.security.service;

import com.miproyecto.primerproyecto.security.entity.Rol;
import com.miproyecto.primerproyecto.security.enums.RolNombre;
import com.miproyecto.primerproyecto.security.repository.RolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository rolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        rolRepository.save(rol);
    }
    
}
