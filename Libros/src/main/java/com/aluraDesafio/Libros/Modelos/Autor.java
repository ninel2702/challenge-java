package com.aluraDesafio.Libros.Modelos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String nombre;
    private int nacimiento;
    private int fallecimiento;
    @OneToMany(mappedBy = "autor",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Libro> libros = new ArrayList<>();

    public Autor(){

    }
    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.nacimiento = datosAutor.nacimiento();
        this.fallecimiento = datosAutor.fallecimiento();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(int nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(int fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return " Nombre: '" + nombre + '\'' +
                ",  Nacimiento: " + nacimiento +
                ",  Fallecimiento: " + fallecimiento +
                ",  Libros registrados: " + (libros != null ? libros.size() : 0);
    }

}
