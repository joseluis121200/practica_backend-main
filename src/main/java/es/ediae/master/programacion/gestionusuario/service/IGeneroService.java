package es.ediae.master.programacion.gestionusuario.service;

import es.ediae.master.programacion.gestionusuario.models.GeneroModel;
import java.util.List;

public interface IGeneroService {
    public List<GeneroModel> obtenerGeneros(String authNick, String authPass);
}
