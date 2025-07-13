package com.aluraDesafio.Libros.Modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(@JsonAlias("title") String titulo,
                         @JsonAlias("authors") List<DatosAutor> autor,
                         @JsonAlias("languages") List<String> idioma,
                         @JsonAlias("summaries")  List<String> sinopsis,
                         @JsonAlias("download_count") int numeroDescargas) {
}
