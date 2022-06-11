package com.miproyecto.primerproyecto.service;

import com.miproyecto.primerproyecto.model.RedesSociales;
import java.util.List;

public interface IRedesService {
    
    public List<RedesSociales> verRedes();
    public void crearRedes(RedesSociales red);
    public void borrarRedes(Long id);
    public RedesSociales buscarRedes(Long id);
    public RedesSociales editarRedes(RedesSociales red);
    
}
