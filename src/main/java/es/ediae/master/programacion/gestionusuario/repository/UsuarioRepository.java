package es.ediae.master.programacion.gestionusuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ediae.master.programacion.gestionusuario.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNickUsuario(String nickUsuario);

    Optional<Usuario> findByNickUsuarioAndContrasena(String nickUsuario, String contrasena);
}
