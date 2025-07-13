package com.aluraDesafio.Libros.Repository;
import com.aluraDesafio.Libros.Modelos.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aluraDesafio.Libros.Modelos.Libro;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long>{
   Optional<Libro> findByTituloContainingIgnoreCase(String nombreLibro);

   List<Libro> findByAutorNombreIgnoreCaseContaining(String nombreAutor);

    List<Libro> findTop10ByOrderByNumeroDescargasDesc();

    List<Libro> findByIdioma(String idioma);
    @Query("SELECT l FROM Libro l JOIN l.autor a WHERE LOWER(a.nombre) LIKE LOWER(CONCAT('%', :nombreAutor, '%'))")
    List<Libro> librosPorAutor(String nombreAutor);



}
