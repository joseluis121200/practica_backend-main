package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.Genero;
import es.ediae.master.programacion.gestionusuario.models.GeneroModel;
import es.ediae.master.programacion.gestionusuario.repository.GeneroRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IGeneroService;
import java.util.List;
import java.util.Optional;
import es.ediae.master.programacion.gestionusuario.entity.Usuario;

@Service
public class GeneroServiceImpl implements IGeneroService {
    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository; // Para la seguridad

    @Override
    public List<GeneroModel> obtenerGeneros(String authNick, String authPass) {
        // 1. Seguridad (Requisito 2.3)
        if (usuarioRepository.findByNickUsuarioAndContrasena(authNick, authPass).isEmpty()) {
            return null;
        }

        // 2. Obtener todas las entidades
        List<Genero> entidades = generoRepository.findAll();

        // 3. Mapear a modelos
        List<GeneroModel> modelos = new ArrayList<>();
        for (Genero e : entidades) {
            GeneroModel m = new GeneroModel();
            m.setId(e.getId());
            m.setNombre(e.getNombre());
            modelos.add(m);
        }
        return modelos;
    }

}
