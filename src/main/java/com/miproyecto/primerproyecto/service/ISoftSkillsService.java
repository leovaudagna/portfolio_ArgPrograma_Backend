package com.miproyecto.primerproyecto.service;

import com.miproyecto.primerproyecto.model.SoftSkills;
import java.util.List;


public interface ISoftSkillsService {
    
    public List<SoftSkills> verSoftSkills();
    public void crearSoftSkills(SoftSkills sskills);
    public void borrarSoftSkills(Long id);
    public SoftSkills buscarSoftSkills(Long id);
    public SoftSkills editarSoftSkills(SoftSkills sskills);
}
