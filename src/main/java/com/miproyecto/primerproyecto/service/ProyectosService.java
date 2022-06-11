package com.miproyecto.primerproyecto.service;

import com.miproyecto.primerproyecto.model.Proyectos;
import com.miproyecto.primerproyecto.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProyectosService implements IProyectosService{

    @Autowired
    public ProyectosRepository proyectosRepo;    
    
    @Override
    public List<Proyectos> verProyectos() {
        return proyectosRepo.findAll();
    }

    @Override
    public void crearProyectos(Proyectos edu) {
        proyectosRepo.save(edu);
    }    
   
    @Override
    public void borrarProyectos(Long id) {
        proyectosRepo.deleteById(id);
    }

    @Override
    public Proyectos buscarProyectos(Long id) {
        return proyectosRepo.findById(id).orElse(null);
    }
    
    //NUEVO: si no funciona, borrar.
    @Override
    public Proyectos editarProyectos(Proyectos proy){
        return proyectosRepo.save(proy);
    }

}
