package com.miproyecto.primerproyecto.controller;

import com.miproyecto.primerproyecto.model.Persona;
import com.miproyecto.primerproyecto.model.Proyectos;
import com.miproyecto.primerproyecto.repository.PersonaRepository;
import com.miproyecto.primerproyecto.repository.ProyectosRepository;
import com.miproyecto.primerproyecto.service.IProyectosService;
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
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerProyectos {
    
    @Autowired
    private PersonaRepository persoRepository;
        
    @Autowired
    private IProyectosService proyectosService;
        
    @GetMapping ("proyectos/ver")
    @ResponseBody
    public List<Proyectos> verProyectos() {
        return proyectosService.verProyectos();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("proyectos/nueva/{id}")
    public void agregarProyectos(@RequestBody Proyectos proy, @PathVariable Long id){
        
        Persona persona = persoRepository.getById(id);
        persona.getProyectos().add(proy);
        
        proyectosService.crearProyectos(proy);       
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("proyectos/delete/{id}")
    public void borrarProyectos(@PathVariable Long id){
        proyectosService.borrarProyectos(id);
        
    }    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("proyectos/editar")
    public ResponseEntity<Proyectos> editarProyectos(@RequestBody Proyectos proyectos){
        Proyectos updateProyectos = proyectosService.editarProyectos(proyectos);
        return new ResponseEntity<>(updateProyectos, HttpStatus.OK);
    }   
    
//    @PutMapping ("proyectos/editar/{id}")
//    public String editarProyectos (@PathVariable Long id,
//                                      @RequestParam (name="nombre", required=false) String nuevoNombre,
//                                      @RequestParam (name="descripcion", required=false) String nuevoDescripcion,
//                                      @RequestParam (name="link", required=false) String nuevoLink,
//                                      @RequestParam (name="img", required=false) String nuevoImg
//                                      ) {
//        
//       Proyectos proy = proyectosService.buscarProyectos(id);
//        proy.setNombreProy(nuevoNombre);
//        proy.setDescrProy(nuevoDescripcion);
//        proy.setLinkProy(nuevoLink);
//        proy.setImgProy(nuevoImg);
//        
//        
//        proyectosService.crearProyectos(proy);
//        
//        return "Proyecto editado";
//       
//    }
    
}
