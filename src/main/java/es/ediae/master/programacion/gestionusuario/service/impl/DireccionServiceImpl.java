package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.ediae.master.programacion.gestionusuario.entity.Direccion;
import es.ediae.master.programacion.gestionusuario.entity.Usuario;
import es.ediae.master.programacion.gestionusuario.models.DireccionModel;
import es.ediae.master.programacion.gestionusuario.repository.DireccionRepository;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IDireccionService;

@Service
public class DireccionServiceImpl implements IDireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<DireccionModel> obtenerDirecciones(Integer idUsuario, String authNick, String authPass) {
        if (usuarioRepository.findByNickUsuarioAndContrasena(authNick, authPass).isEmpty()) return null;

        List<Direccion> entidades = direccionRepository.findByUsuarioId(idUsuario);
        List<DireccionModel> modelos = new ArrayList<>();
        for (Direccion e : entidades) {
            modelos.add(entidadAModelo(e));
        }
        return modelos;
    }

    @Override
    public DireccionModel obtenerDireccion(Integer id, String authNick, String authPass) {
        if (usuarioRepository.findByNickUsuarioAndContrasena(authNick, authPass).isEmpty()) return null;

        return direccionRepository.findById(id)
                .map(this::entidadAModelo)
                .orElse(null);
    }

    @Override
    public DireccionModel crearDireccion(DireccionModel model, String authNick, String authPass) {
        if (usuarioRepository.findByNickUsuarioAndContrasena(authNick, authPass).isEmpty()) return null;

        Optional<Usuario> dueno = usuarioRepository.findById(model.getIdUsuario());
        if (dueno.isEmpty()) return null;

        Direccion nueva = new Direccion();
        nueva.setNombre_calle(model.getNombre_calle());
        nueva.setNumero_calle(model.getNumero_calle());
        nueva.setDireccion_principal(model.isDireccion_principal());
        nueva.setUsuario(dueno.get());

        return entidadAModelo(direccionRepository.save(nueva));
    }

    @Override
    public DireccionModel actualizarDireccion(Integer id, DireccionModel model, String authNick, String authPass) {
        if (usuarioRepository.findByNickUsuarioAndContrasena(authNick, authPass).isEmpty()) return null;

        Optional<Direccion> existente = direccionRepository.findById(id);
        if (existente.isEmpty()) return null;

        Direccion entidad = existente.get();
        entidad.setNombre_calle(model.getNombre_calle());
        entidad.setNumero_calle(model.getNumero_calle());
        entidad.setDireccion_principal(model.isDireccion_principal());

        if (entidad.getUsuario().getId() != model.getIdUsuario()) {
            usuarioRepository.findById(model.getIdUsuario()).ifPresent(entidad::setUsuario);
        }

        return entidadAModelo(direccionRepository.save(entidad));
    }

    @Override
    public void eliminarDireccion(Integer id, String authNick, String authPass) {
        if (usuarioRepository.findByNickUsuarioAndContrasena(authNick, authPass).isPresent()) {
            direccionRepository.deleteById(id);
        }
    }

    private DireccionModel entidadAModelo(Direccion e) {
        DireccionModel m = new DireccionModel();
        m.setId(e.getId());
        m.setNombre_calle(e.getNombre_calle());
        m.setNumero_calle(e.getNumero_calle());
        m.setDireccion_principal(e.isDireccion_principal());
        if (e.getUsuario() != null) {
            m.setIdUsuario(e.getUsuario().getId());
        }
        return m;
    }
}
