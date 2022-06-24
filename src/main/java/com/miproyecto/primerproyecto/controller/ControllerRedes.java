package com.miproyecto.primerproyecto.controller;


import com.miproyecto.primerproyecto.model.Persona;
import com.miproyecto.primerproyecto.model.RedesSociales;
import com.miproyecto.primerproyecto.repository.PersonaRepository;
import com.miproyecto.primerproyecto.service.IRedesService;
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
public class ControllerRedes {
    
    @Autowired
    private PersonaRepository persoRepository;
        
    @Autowired
    private IRedesService redesService;
        
    @GetMapping ("redes/ver")
    @ResponseBody
    public List<RedesSociales> verRedes() {
        return redesService.verRedes();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("redes/nueva/{id}")
    public void agregarRedes(@RequestBody RedesSociales red, @PathVariable Long id){
        
        Persona persona = persoRepository.getById(id);
        persona.getRedes().add(red);
        
        redesService.crearRedes(red);       
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("redes/delete/{id}")
    public void borrarRedes(@PathVariable Long id){
        redesService.borrarRedes(id);
        
    }    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("redes/editar")
    public ResponseEntity<RedesSociales> editarRedes(@RequestBody RedesSociales redes){
        RedesSociales updateRedes = redesService.editarRedes(redes);
        return new ResponseEntity<>(updateRedes, HttpStatus.OK);
    }  
    
    
//    @PutMapping ("redes/editar/{id}")
//    public String editarRedes (@PathVariable Long id,
//                               @RequestParam(name = "nombreRed", required=false) String nuevoNombre,
//                               @RequestParam(name = "urlRed", required=false) String nuevoUrl
//                                      ) {
//        
//       RedesSociales red =  redesService.buscarRedes(id);
//       
//       red.setNombreRed(nuevoNombre);
//       red.setUrlRed(nuevoUrl);
//       
//       redesService.crearRedes(red);
//       
//       return "Red Social editada";
       
//    }
       
    
}
