package es.ediae.master.programacion.gestionusuario.service;

import java.util.List;

import es.ediae.master.programacion.gestionusuario.models.UsuarioModel;

public interface IUsuarioService {
    List<UsuarioModel> obtenerUsuarios(String authNick, String authPass);
    UsuarioModel crearUsuario(UsuarioModel model, String authNick, String authPass);
    UsuarioModel actualizarUsuario(Integer id, UsuarioModel model, String authNick, String authPass);
    void eliminarUsuario(Integer id, String authNick, String authPass);
    boolean iniciarSesion(String nickUsuario, String contrasena);
    UsuarioModel obtenerUsuarioPorNick(String nickUsuario, String authNick, String authPass);
}
