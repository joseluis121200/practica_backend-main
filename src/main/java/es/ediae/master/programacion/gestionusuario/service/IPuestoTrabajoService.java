package es.ediae.master.programacion.gestionusuario.service;

import es.ediae.master.programacion.gestionusuario.models.PuestoDeTrabajoModel;
import java.util.List;

public interface IPuestoTrabajoService {
    List<PuestoDeTrabajoModel> obtenerPuestosDeTrabajo(String authNick, String authPass);
}
