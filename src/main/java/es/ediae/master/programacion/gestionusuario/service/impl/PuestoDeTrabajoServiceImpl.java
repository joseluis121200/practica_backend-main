package es.ediae.master.programacion.gestionusuario.service.impl;

import es.ediae.master.programacion.gestionusuario.service.IPuestoTrabajoService;
import es.ediae.master.programacion.gestionusuario.models.PuestoDeTrabajoModel;
import java.util.List;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import es.ediae.master.programacion.gestionusuario.repository.PuestoTrabajoRepository;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajo;

@Service
public class PuestoDeTrabajoServiceImpl implements IPuestoTrabajoService {
    @Autowired
    private PuestoTrabajoRepository puestoTrabajoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<PuestoDeTrabajoModel> obtenerPuestosDeTrabajo(String authNick, String authPass) {
       if (usuarioRepository.findByNickUsuarioAndContrasena(authNick, authPass).isEmpty())
        {
            return null;
        }

        List<PuestoDeTrabajo> entidades = puestoTrabajoRepository.findAll();

        List<PuestoDeTrabajoModel> modelos = new ArrayList<>();
        for (PuestoDeTrabajo e : entidades) {
            PuestoDeTrabajoModel m = new PuestoDeTrabajoModel();
            m.setId(e.getId());
            m.setNombre(e.getNombre());
            modelos.add(m);
        }
        return modelos;
    }


}
