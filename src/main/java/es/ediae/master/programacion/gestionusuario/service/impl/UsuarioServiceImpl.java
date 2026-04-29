package es.ediae.master.programacion.gestionusuario.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.ediae.master.programacion.gestionusuario.entity.Usuario;
import es.ediae.master.programacion.gestionusuario.models.UsuarioModel;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IUsuarioService;




@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
public List<UsuarioModel> obtenerUsuarios(String authNick, String authPass) {
    Optional<Usuario> quienPide = usuarioRepository.findByNickUsuarioAndContrasena(authNick, authPass);
    if (quienPide.isEmpty()) {
        return null; 
    }

    List<Usuario> entidades = usuarioRepository.findAll();
    
    List<UsuarioModel> modelos = new ArrayList<>();
    for (Usuario u : entidades) {
        UsuarioModel m = new UsuarioModel();
        m.setId(u.getId());
        m.setNombre(u.getNombre());
        m.setNickUsuario(u.getNickUsuario());
        m.setEsAdmin(u.isEsAdmin());
        modelos.add(m);
    }

    return modelos;
}


    @Override
    public boolean iniciarSesion(String nick, String password) {
        return usuarioRepository.findByNickUsuarioAndContrasena(nick, password).isPresent();
    }




    @Override
public UsuarioModel crearUsuario(UsuarioModel model, String authNick, String authPass) {
    // 1. SEGURIDAD: ¿Quién intenta crear?
    if (usuarioRepository.findByNickUsuarioAndContrasena(authNick, authPass).isEmpty()) {
        return null;
    }

    // 2. REQUISITO 2.2: ¿El nick ya existe?
    Optional<Usuario> usuarioExistente = usuarioRepository.findByNickUsuario(model.getNickUsuario());
    if (usuarioExistente.isPresent()) {
        // Si el nick ya existe, no creamos nada y devolvemos null
        return null; 
    }

    // 3. PASAR DE MODELO A ENTIDAD (Para que JPA pueda guardarlo)
    Usuario nuevaEntidad = new Usuario();
    nuevaEntidad.setNombre(model.getNombre());
    nuevaEntidad.setNickUsuario(model.getNickUsuario());
    nuevaEntidad.setEsAdmin(model.isEsAdmin());

    // 4. GUARDAR EN DB
    Usuario entidadGuardada = usuarioRepository.save(nuevaEntidad);

    // 5. DEVOLVER COMO MODELO (El "traductor" de vuelta)
    UsuarioModel resultado = new UsuarioModel();
    resultado.setId(entidadGuardada.getId());
    resultado.setNombre(entidadGuardada.getNombre());
    resultado.setNickUsuario(entidadGuardada.getNickUsuario());
    resultado.setEsAdmin(entidadGuardada.isEsAdmin());

    return resultado;
}

@Override
public UsuarioModel obtenerUsuarioPorId(Integer id, String authNick, String authPass) {
    if (usuarioRepository.findByNickUsuarioAndContrasena(authNick, authPass).isEmpty()) {
        return null;
    }
    Optional<Usuario> entity = usuarioRepository.findById(id);
    
    if (entity.isPresent()) {
        Usuario u = entity.get();
        UsuarioModel model = new UsuarioModel();
        model.setId(u.getId());
        model.setNombre(u.getNombre());
        model.setNickUsuario(u.getNickUsuario());
        model.setEsAdmin(u.isEsAdmin());
        return model;
    }
    
    return null;
}







   @Override
public UsuarioModel actualizarUsuario(Integer id, UsuarioModel model, String authNick, String authPass) {
    if (usuarioRepository.findByNickUsuarioAndContrasena(authNick, authPass).isEmpty()) {
        return null;
    }

    Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
    if (usuarioExistente.isEmpty()) {
        return null; 
    }

    Usuario entidad = usuarioExistente.get();
    
    entidad.setNombre(model.getNombre());
    entidad.setEsAdmin(model.isEsAdmin());
    entidad.setContrasena(model.getContrasena());
    entidad.setNickUsuario(model.getNickUsuario());
    if (model.getContrasena() != null && !model.getContrasena().isEmpty()) {
        entidad.setContrasena(model.getContrasena());
    }

    Usuario entidadActualizada = usuarioRepository.save(entidad);

    UsuarioModel resultado = new UsuarioModel();
    resultado.setId(entidadActualizada.getId());
    resultado.setNombre(entidadActualizada.getNombre());
    resultado.setNickUsuario(entidadActualizada.getNickUsuario());
    resultado.setEsAdmin(entidadActualizada.isEsAdmin());

    return resultado;
}

    @Override
public void eliminarUsuario(Integer id, String authNick, String authPass) {
    Optional<Usuario> quienPide = usuarioRepository.findByNickUsuarioAndContrasena(authNick, authPass);
    
    if (quienPide.isPresent()) {
        usuarioRepository.deleteById(id);
        
    }
    
}

    private List<UsuarioModel> convertirAListaModel(List<Usuario> listaDeEntidades) {
    List<UsuarioModel> listaDeModelos = new ArrayList<>();

    for (Usuario entidad : listaDeEntidades) {
        
        UsuarioModel modelo = new UsuarioModel();
        
        modelo.setId(entidad.getId());
        modelo.setNombre(entidad.getNombre());
        modelo.setNickUsuario(entidad.getNickUsuario());
        modelo.setEsAdmin(entidad.isEsAdmin());
        
        listaDeModelos.add(modelo);
    }

    return listaDeModelos;
}

}
