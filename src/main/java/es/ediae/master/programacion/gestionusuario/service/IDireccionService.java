package es.ediae.master.programacion.gestionusuario.service;

import es.ediae.master.programacion.gestionusuario.models.DireccionModel;
import java.util.List;

public interface IDireccionService {
    List<DireccionModel> obtenerDirecciones(Integer idUsuario, String authNick, String authPass);
    DireccionModel obtenerDireccion(Integer id, String authNick, String authPass);
    DireccionModel crearDireccion(DireccionModel model, String authNick, String authPass);
    DireccionModel actualizarDireccion(Integer id, DireccionModel model, String authNick, String authPass);
    void eliminarDireccion(Integer id, String authNick, String authPass);
}
