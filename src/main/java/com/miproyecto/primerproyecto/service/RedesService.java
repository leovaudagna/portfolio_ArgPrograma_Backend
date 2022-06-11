package com.miproyecto.primerproyecto.service;

import com.miproyecto.primerproyecto.model.RedesSociales;
import com.miproyecto.primerproyecto.repository.RedesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedesService implements IRedesService {

    @Autowired
    public RedesRepository redesRepo;
    
    
    @Override
    public List<RedesSociales> verRedes() {
        return redesRepo.findAll();    
    }

    @Override
    public void crearRedes(RedesSociales red) {
        redesRepo.save(red);
    }

    @Override
    public void borrarRedes(Long id) {
        redesRepo.deleteById(id);
    }

    @Override
    public RedesSociales buscarRedes(Long id) {
        return redesRepo.findById(id).orElse(null);
    }
    
    @Override
    public RedesSociales editarRedes(RedesSociales red){
        return redesRepo.save(red);
    }
    
}
