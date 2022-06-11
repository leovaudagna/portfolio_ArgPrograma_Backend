package com.miproyecto.primerproyecto.repository;

import com.miproyecto.primerproyecto.model.RedesSociales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedesRepository extends JpaRepository <RedesSociales, Long>  {
    
}
