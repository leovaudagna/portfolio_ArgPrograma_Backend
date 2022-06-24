package com.miproyecto.primerproyecto.controller;

import com.miproyecto.primerproyecto.model.Educacion;
import com.miproyecto.primerproyecto.model.Persona;
import com.miproyecto.primerproyecto.repository.PersonaRepository;
import com.miproyecto.primerproyecto.service.IEducacionService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("edicion/")
@CrossOrigin(origins = "*")
public class ControllerEducacion {
    
    @Autowired
    private PersonaRepository persoRepository;
        
    @Autowired
    private IEducacionService educacionService;
        
    @GetMapping ("educacion/ver")
    @ResponseBody
    public List<Educacion> verEducacion() {
        return educacionService.verEducacion();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("educacion/nueva/{id}")
    public void agregarEducacion(@RequestBody Educacion edu, @PathVariable Long id){
        
        Persona persona = persoRepository.getById(id);
        persona.getEducacion().add(edu);
        
        educacionService.crearEducacion(edu);       
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("educacion/delete/{id}")
    public void borrarEducacion(@PathVariable Long id){
        educacionService.borrarEducacion(id);
        
    }    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("educacion/editar")
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion educacion){
        Educacion updateEducacion = educacionService.editarEducacion(educacion);
        return new ResponseEntity<>(updateEducacion, HttpStatus.OK);
    }
   
//    @PutMapping ("educacion/editar/{id}")
//    public String editarEducacion (
//            @PathVariable Long id,
//            @RequestParam(name = "establecimiento", required = false) String nuevoEstablecimiento,
//            @RequestParam(name = "titulo", required = false) String nuevoTitulo,
//            @RequestParam(name = "fecha_inic_ed", required = false) String nuevoFechaIni,
//            @RequestParam(name = "fecha_fin_ed", required = false) String nuevoFechaFin,
//            @RequestParam(name = "logo_url", required = false) String nuevoLogo
//    ) {
//        
//       Educacion edu =  educacionService.buscarEducacion(id);
//       
//       edu.setEstablecimiento(nuevoEstablecimiento);
//       edu.setTitulo(nuevoTitulo);
//       edu.setFechaInic_ed(nuevoFechaIni);
//       edu.setFechaFin_ed(nuevoFechaFin);
//       edu.setLogoUrl(nuevoLogo);
//       
//       educacionService.crearEducacion(edu);
//       
//       return "Educacion editada";
//       
//    }
       
    
}
