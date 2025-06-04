package com.example.demo.Repository;

import com.example.demo.Entity.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    // Método derivado por nombre (lista completa)
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    // Método derivado por nombre con paginación
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    // JPQL - lista completa
    @Query("SELECT p FROM Persona p WHERE p.nombre LIKE CONCAT('%', :filtro, '%') OR p.apellido LIKE CONCAT('%', :filtro, '%')")
    List<Persona> search(@Param("filtro") String filtro);

    // JPQL - paginado
    @Query("SELECT p FROM Persona p WHERE p.nombre LIKE CONCAT('%', :filtro, '%') OR p.apellido LIKE CONCAT('%', :filtro, '%')")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    // Consulta nativa - lista completa
    @Query(
            value = "SELECT * FROM persona WHERE nombre LIKE CONCAT('%', :filtro, '%') OR apellido LIKE CONCAT('%', :filtro, '%')",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);

    // Consulta nativa - paginado
    @Query(
            value = "SELECT id, nombre, apellido FROM persona WHERE nombre LIKE CONCAT('%', :filtro, '%') OR apellido LIKE CONCAT('%', :filtro, '%')",
            countQuery = "SELECT COUNT(*) FROM persona WHERE nombre LIKE CONCAT('%', :filtro, '%') OR apellido LIKE CONCAT('%', :filtro, '%')",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
