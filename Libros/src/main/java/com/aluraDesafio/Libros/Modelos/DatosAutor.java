package com.aluraDesafio.Libros.Modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(@JsonAlias("name") String nombre,
                         @JsonAlias("birth_year")int nacimiento,
                         @JsonAlias("death_year")int fallecimiento){
}
