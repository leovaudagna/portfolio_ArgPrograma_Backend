package com.miproyecto.primerproyecto.service;

import com.miproyecto.primerproyecto.model.HardSkills;
import com.miproyecto.primerproyecto.repository.HardSkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HardSkillsService implements IHardSkillsService {
    
    @Autowired
    public HardSkillsRepository hskillsRepo;
    
    @Override
    public List<HardSkills> verHardSkills() {
        return hskillsRepo.findAll();    
    }

    @Override
    public void crearHardSkills(HardSkills hskills) {
        hskillsRepo.save(hskills);
    }

    @Override
    public void borrarHardSkills(Long id) {
        hskillsRepo.deleteById(id);
    }

    @Override
    public HardSkills buscarHardSkills(Long id) {
        return hskillsRepo.findById(id).orElse(null);
    }
    
    @Override
    public HardSkills editarHardSkills(HardSkills hskills){
        return hskillsRepo.save(hskills);
    }
    
}
