package com.miproyecto.primerproyecto.controller;

import com.miproyecto.primerproyecto.model.Persona;
import com.miproyecto.primerproyecto.service.IPersonaService;
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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("edicion/")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerPersona {
    
    @Autowired
    private IPersonaService persoServ;
    
    
    
    @GetMapping ("persona/ver")
    @ResponseBody
    public List<Persona> verPersonas() {
        return persoServ.verPersonas();
    }
    
    @GetMapping ("persona/buscar/{id}")
    @ResponseBody
    public ResponseEntity<Persona> buscarPersona(@PathVariable Long id) {
        Persona persona = persoServ.buscarPersona(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("persona/nueva")
    public void agregarPersona(@RequestBody Persona pers){
        persoServ.crearPersona(pers);
    }
    
//    Del video de Camacho
    
    
//    @GetMapping("persona/ver/{id}")
//    public Persona buscarPersona(@PathVariable Long id){
//        return persoServ.buscarPersona(id);
//    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("persona/delete/{id}")
    public void borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("persona/editar")
    public ResponseEntity<Persona> editarPersona(@RequestBody Persona persona){
        Persona updatePersona = persoServ.editarPersona(persona);
        return new ResponseEntity<>(updatePersona, HttpStatus.OK);
    }  
    
//    @PutMapping ("personas/editar/{id}")
//    public Persona editarPersona (@PathVariable Long id,
//                                  @RequestParam (name="nombre", required=false) String nuevoNombre,
//                                  @RequestParam (name="apellido", required=false) String nuevoApellido,
//                                  @RequestParam (name="titulo", required=false) String nuevoTitulo,
//                                  @RequestParam (name="fechaNac", required=false) String nuevoFechaNac,
//                                  @RequestParam (name="acercaDe", required=false) String nuevoAcercaDe,
//                                  @RequestParam (name="urlFoto", required=false) String nuevoUrlFoto,
//                                  @RequestParam (name="correoElectronico", required=false) String nuevoCorreo){
//        
//        Persona perso = persoServ.buscarPersona(id);
//        perso.setNombre(nuevoNombre);
//        perso.setApellido(nuevoApellido);
//        perso.setTitulo(nuevoTitulo);
//        perso.setFechaNac(nuevoFechaNac);
//        perso.setAcercaDe(nuevoAcercaDe);
//        perso.setUrlFoto(nuevoUrlFoto);
//        perso.setCorreoElectronico(nuevoCorreo);
//        
//        
//        persoServ.crearPersona(perso);
//        
//        return perso;
//    }
    
       

}
    
    

/*
    PRUEBAS CON USUARIO DTO --- REVISAR
    
    @GetMapping ("/user/portfolio")
    @ResponseBody
    public UsuarioDTO usuarioCompleto(@PathVariable Long id){
    
        User user = new User();
        Persona persona = new Persona();
        RedesSociales redes = new RedesSociales();
        Experiencia experiencia = new Experiencia();
        HardSkills hardskills = new HardSkills();
        SoftSkills softskills = new SoftSkills();
        Proyectos proyectos = new Proyectos();
        
        UsuarioDTO usuarioCom = new UsuarioDTO();
        
        
        
    }
    */