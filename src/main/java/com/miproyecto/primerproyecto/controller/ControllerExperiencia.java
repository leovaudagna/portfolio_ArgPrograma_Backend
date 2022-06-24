package com.miproyecto.primerproyecto.controller;

import com.miproyecto.primerproyecto.model.Experiencia;
import com.miproyecto.primerproyecto.model.Persona;
import com.miproyecto.primerproyecto.repository.PersonaRepository;
import com.miproyecto.primerproyecto.service.IExperienciaService;
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
public class ControllerExperiencia {
    
    @Autowired
    private PersonaRepository persoRepository;
        
    @Autowired
    private IExperienciaService experienciaService;
        
    @GetMapping ("experiencia/ver")
    @ResponseBody
    public List<Experiencia> verExperiencian() {
        return experienciaService.verExperiencia();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("experiencia/nueva/{id}")
    public void agregarExperiencia(@RequestBody Experiencia exp, @PathVariable Long id){
        
        Persona persona = persoRepository.getById(id);
        persona.getExperiencia().add(exp);
        
        experienciaService.crearExperiencia(exp);       
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("experiencia/delete/{id}")
    public void borrarExperiencia(@PathVariable Long id){
        experienciaService.borrarExperiencia(id);
        
    }    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("experiencia/editar")
    public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia experiencia){
        Experiencia updateExperiencia = experienciaService.editarExperiencia(experiencia);
        return new ResponseEntity<>(updateExperiencia, HttpStatus.OK);
    }

//    @PutMapping ("experiencia/editar/{id}")
//    public String editarExperiencia (
//            @PathVariable Long id,
//            @RequestParam(name = "empresa", required = false) String nempresa,
//            @RequestParam(name = "rubro", required = false) String nrubro,
//            @RequestParam(name = "descripcion", required = false) String ndescripcion,
//            @RequestParam(name = "fechaInic", required = false) String nfechaInic,
//            @RequestParam(name = "fechaFin", required = false) String nfechaFin,
//            @RequestParam(name = "lugar", required = false) String nlugar
//    ) {
//        
//       Experiencia exp =  experienciaService.buscarExperiencia(id);
//       
//       exp.setEmpresa(nempresa);
//       exp.setRubro(nrubro);
//       exp.setDescripcion(ndescripcion);
//       exp.setFechaInic(nfechaInic);
//       exp.setFechaFin(nfechaFin);
//       exp.setLugar(nlugar);
//       
//       experienciaService.crearExperiencia(exp);
//       
//       return "Experiencia editada";
//       
//    }

}
