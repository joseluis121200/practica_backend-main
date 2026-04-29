package es.ediae.master.programacion.gestionusuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.ediae.master.programacion.gestionusuario.entity.PuestoDeTrabajo;
import java.util.List;

@Repository

public interface  PuestoTrabajoRepository extends JpaRepository<PuestoDeTrabajo, Integer> {
    
}
