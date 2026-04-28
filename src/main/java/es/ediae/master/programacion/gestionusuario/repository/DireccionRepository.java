package es.ediae.master.programacion.gestionusuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.ediae.master.programacion.gestionusuario.entity.Direccion;
import java.util.List;

@Repository
public interface  DireccionRepository extends JpaRepository<Direccion, Integer> {
    List<Direccion> findByUsuarioId(Integer usuarioId);
}
