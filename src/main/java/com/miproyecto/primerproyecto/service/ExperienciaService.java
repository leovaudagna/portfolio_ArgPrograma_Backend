package com.miproyecto.primerproyecto.service;

import com.miproyecto.primerproyecto.model.Experiencia;
import com.miproyecto.primerproyecto.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    public ExperienciaRepository expeRepo;
    
    
    @Override
    public List<Experiencia> verExperiencia() {
        return expeRepo.findAll();    
    }

    @Override
    public void crearExperiencia(Experiencia exp) {
        expeRepo.save(exp);
    }

    @Override
    public void borrarExperiencia(Long id) {
        expeRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return expeRepo.findById(id).orElse(null);
    }
    //NUEVO: si no funciona, borrar.
    @Override
    public Experiencia editarExperiencia(Experiencia edu){
        return expeRepo.save(edu);
    }
    
    
}
