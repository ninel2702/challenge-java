package com.aluraDesafio.Libros.Repository;

import com.aluraDesafio.Libros.Modelos.Autor;
import com.aluraDesafio.Libros.Modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombreIgnoreCase(String nombre);

@Query("SELECT a FROM Autor a WHERE a.nacimiento >= :anio ")
    List<Autor> findByAnio(int anio);
}
