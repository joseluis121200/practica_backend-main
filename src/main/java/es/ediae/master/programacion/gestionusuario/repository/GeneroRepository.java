package es.ediae.master.programacion.gestionusuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.ediae.master.programacion.gestionusuario.entity.Genero;
import java.util.List;

@Repository
public interface  GeneroRepository extends JpaRepository<Genero, Integer> {
    List<Genero> findByUsuarioId(Integer usuarioId);
}
