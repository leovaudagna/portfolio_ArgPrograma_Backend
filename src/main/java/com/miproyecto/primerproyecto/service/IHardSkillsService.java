package com.miproyecto.primerproyecto.service;

import com.miproyecto.primerproyecto.model.HardSkills;
import java.util.List;

public interface IHardSkillsService {
    
    public List<HardSkills> verHardSkills();
    public void crearHardSkills(HardSkills hskills);
    public void borrarHardSkills(Long id);
    public HardSkills buscarHardSkills(Long id);
    public HardSkills editarHardSkills(HardSkills hskills);
    
}
