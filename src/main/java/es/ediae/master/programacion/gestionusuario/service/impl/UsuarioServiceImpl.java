package es.ediae.master.programacion.gestionusuario.service.impl;

import es.ediae.master.programacion.gestionusuario.entity.Usuario;
import es.ediae.master.programacion.gestionusuario.models.UsuarioModel;
import es.ediae.master.programacion.gestionusuario.repository.UsuarioRepository;
import es.ediae.master.programacion.gestionusuario.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




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
    public UsuarioModel obtenerUsuarioPorNick(String nick, String authNick, String authPass) {
        return null; 
    }

    @Override
    public UsuarioModel crearUsuario(UsuarioModel model, String authNick, String authPass) {
        return null; 
    }

    @Override
    public UsuarioModel actualizarUsuario(Integer id, UsuarioModel model, String authNick, String authPass) {
        return null; 
    }

    @Override
    public void eliminarUsuario(Integer id, String authNick, String authPass) {
  
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