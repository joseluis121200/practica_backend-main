package es.ediae.master.programacion.gestionusuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import es.ediae.master.programacion.gestionusuario.models.DireccionModel;
import es.ediae.master.programacion.gestionusuario.service.IDireccionService;
import java.util.List;
import es.ediae.master.programacion.gestionusuario.service.IGeneroService;
import es.ediae.master.programacion.gestionusuario.service.IPuestoTrabajoService;


@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    @Autowired
    private IDireccionService direccionService;

    @GetMapping("/obtenerDirecciones")
    public List<DireccionModel> obtenerDirecciones(
            @RequestParam Integer usuarioId,
            @RequestParam String nickUsuario,
            @RequestParam String contrasena) {
        return direccionService.obtenerDirecciones(usuarioId, nickUsuario, contrasena);
    }

    @GetMapping("/obtenerDireccion")
    public DireccionModel obtenerDireccion(
            @RequestParam Integer id,
            @RequestParam String nickUsuario,
            @RequestParam String contrasena) {
        return direccionService.obtenerDireccion(id, nickUsuario, contrasena);
    }

    @PostMapping("/crearDireccion")
    public DireccionModel crearDireccion(
            @RequestBody DireccionModel direccion,
            @RequestParam String nickUsuario,
            @RequestParam String contrasena) {
        return direccionService.crearDireccion(direccion, nickUsuario, contrasena);
    }

    @PutMapping("/actualizarDireccion")
    public DireccionModel actualizarDireccion(
            @RequestParam Integer id,
            @RequestBody DireccionModel direccion,
            @RequestParam String nickUsuario,
            @RequestParam String contrasena) {
        return direccionService.actualizarDireccion(id, direccion, nickUsuario, contrasena);
    }

    @DeleteMapping("/eliminarDireccion")
    public void eliminarDireccion(
            @RequestParam Integer id,
            @RequestParam String nickUsuario,
            @RequestParam String contrasena) {
        direccionService.eliminarDireccion(id, nickUsuario, contrasena);
    }
}
