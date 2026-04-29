package es.ediae.master.programacion.gestionusuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import es.ediae.master.programacion.gestionusuario.models.UsuarioModel;
import es.ediae.master.programacion.gestionusuario.models.GeneroModel;
import es.ediae.master.programacion.gestionusuario.models.PuestoDeTrabajoModel;
import es.ediae.master.programacion.gestionusuario.service.IUsuarioService;
import es.ediae.master.programacion.gestionusuario.service.IGeneroService;
import es.ediae.master.programacion.gestionusuario.service.IPuestoTrabajoService;
import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IGeneroService generoService;

    @Autowired
    private IPuestoTrabajoService puestoService;

    // 1. INICIAR SESIÓN
    @PostMapping("/iniciarSesion")
    public boolean iniciarSesion(@RequestParam String nick, @RequestParam String pass) {
        return usuarioService.iniciarSesion(nick, pass);
    }

    // 2. OBTENER TODOS LOS USUARIOS
    @GetMapping
    public List<UsuarioModel> obtenerUsuarios(
            @RequestParam String nickUsuario, 
            @RequestParam String nickContrasena) {
        return usuarioService.obtenerUsuarios(nickUsuario, nickContrasena);
    }

    // 3. OBTENER UN USUARIO POR ID
    @GetMapping("/{id}")
    public UsuarioModel obtenerUsuario(
            @PathVariable Integer id,
            @RequestParam String nickUsuario, 
            @RequestParam String nickContrasena) {
        return usuarioService.obtenerUsuarioPorId(id, nickUsuario, nickContrasena);
    }

    // 4. CREAR USUARIO
    @PostMapping
    public UsuarioModel crearUsuario(
            @RequestBody UsuarioModel model,
            @RequestParam String nickUsuario, 
            @RequestParam String nickContrasena) {
        return usuarioService.crearUsuario(model, nickUsuario, nickContrasena);
    }

    // 5. ACTUALIZAR USUARIO
    @PutMapping("/{id}")
    public UsuarioModel actualizarUsuario(
            @PathVariable Integer id,
            @RequestBody UsuarioModel model,
            @RequestParam String nickUsuario, 
            @RequestParam String nickContrasena) {
        return usuarioService.actualizarUsuario(id, model, nickUsuario, nickContrasena);
    }

    // 6. ELIMINAR USUARIO
    @DeleteMapping("/{id}")
    public void eliminarUsuario(
            @PathVariable Integer id,
            @RequestParam String nickUsuario, 
            @RequestParam String nickContrasena) {
        usuarioService.eliminarUsuario(id, nickUsuario, nickContrasena);
    }

    // --- MÉTODOS DE OTROS SERVICIOS (GÉNEROS Y PUESTOS) ---

    @GetMapping("/generos")
    public List<GeneroModel> obtenerGeneros(
            @RequestParam String nickUsuario, 
            @RequestParam String nickContrasena) {
        return generoService.obtenerGeneros(nickUsuario, nickContrasena);
    }

    @GetMapping("/puestos")
    public List<PuestoDeTrabajoModel> obtenerPuestosDeTrabajo(
            @RequestParam String nickUsuario, 
            @RequestParam String nickContrasena) {
        return puestoService.obtenerPuestosDeTrabajo(nickUsuario, nickContrasena);
    }
}