package com.miproyecto.primerproyecto.controller;

import com.miproyecto.primerproyecto.model.Persona;
import com.miproyecto.primerproyecto.model.SoftSkills;
import com.miproyecto.primerproyecto.repository.PersonaRepository;
import com.miproyecto.primerproyecto.service.ISoftSkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("edicion/")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerSoftSkills {
    
    @Autowired
    private PersonaRepository persoRepository;
        
    @Autowired
    private ISoftSkillsService sskillsService;
        
    @GetMapping ("softskills/ver")
    @ResponseBody
    public List<SoftSkills> verSoftSkills() {
        return sskillsService.verSoftSkills();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("softskills/nueva/{id}")
    public void agregarSoftSkills(@RequestBody SoftSkills sskills, @PathVariable Long id){
        
        Persona persona = persoRepository.getById(id);
        persona.getSskills().add(sskills);
        
        sskillsService.crearSoftSkills(sskills);       
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("softskills/delete/{id}")
    public void borrarHardSkills(@PathVariable Long id){
        sskillsService.borrarSoftSkills(id);
        
    }    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("softskills/editar")
    public ResponseEntity<SoftSkills> editarSoftSkills(@RequestBody SoftSkills softskills){
        SoftSkills updateSoftSkills = sskillsService.editarSoftSkills(softskills);
        return new ResponseEntity<>(updateSoftSkills, HttpStatus.OK);
    }  
    
    
//    @PutMapping ("hskills/editar/{id}")
//    public String editarHardSkills (
//            @PathVariable Long id,
//            @RequestParam("nombre") String nombre,
//            @RequestParam("porcentaje") Long porcentaje
//                                      ) {
//        
//       HardSkills hskill =  hskillsService.buscarHardSkills(id);
//       
//       hskill.setNombreHSkill(nombre);
//       hskill.setPorcentajeHSkill(porcentaje);
//
//       
//       hskillsService.crearHardSkills(hskill);
//       
//       return "Hard Skill editada";
//       
//    }
}
