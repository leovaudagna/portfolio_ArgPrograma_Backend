package com.miproyecto.primerproyecto.service;

import com.miproyecto.primerproyecto.model.SoftSkills;
import com.miproyecto.primerproyecto.repository.SoftSkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftSkillsService implements ISoftSkillsService {
    
    @Autowired
    public SoftSkillsRepository sskillsRepo;
    
    @Override
    public List<SoftSkills> verSoftSkills() {
        return sskillsRepo.findAll();    
    }

    @Override
    public void crearSoftSkills(SoftSkills sskills) {
        sskillsRepo.save(sskills);
    }

    @Override
    public void borrarSoftSkills(Long id) {
        sskillsRepo.deleteById(id);
    }

    @Override
    public SoftSkills buscarSoftSkills(Long id) {
        return sskillsRepo.findById(id).orElse(null);
    }
    
    //NUEVO: si no funciona, borrar.
    @Override
    public SoftSkills editarSoftSkills(SoftSkills sskills){
        return sskillsRepo.save(sskills);
    }
    
}
