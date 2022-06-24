package com.miproyecto.primerproyecto.controller;

import com.miproyecto.primerproyecto.model.HardSkills;
import com.miproyecto.primerproyecto.model.Persona;
import com.miproyecto.primerproyecto.repository.PersonaRepository;
import com.miproyecto.primerproyecto.service.IHardSkillsService;
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
@CrossOrigin(origins = "*")
public class ControllerHardSkills {
    
    @Autowired
    private PersonaRepository persoRepository;
        
    @Autowired
    private IHardSkillsService hskillsService;
        
    @GetMapping ("hardskills/ver")
    @ResponseBody
    public List<HardSkills> verHardSkills() {
        return hskillsService.verHardSkills();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("hardskills/nueva/{id}")
    public void agregarHardSkills(@RequestBody HardSkills hskills, @PathVariable Long id){
        
        Persona persona = persoRepository.getById(id);
        persona.getHskills().add(hskills);
        
        hskillsService.crearHardSkills(hskills);       
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("hardskills/delete/{id}")
    public void borrarHardSkills(@PathVariable Long id){
        hskillsService.borrarHardSkills(id);
        
    }    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("hardskills/editar")
    public ResponseEntity<HardSkills> editarHardSkills(@RequestBody HardSkills hardskills){
        HardSkills updateHardSkills = hskillsService.editarHardSkills(hardskills);
        return new ResponseEntity<>(updateHardSkills, HttpStatus.OK);
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
