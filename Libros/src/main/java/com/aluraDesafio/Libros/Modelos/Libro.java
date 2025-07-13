package com.aluraDesafio.Libros.Modelos;

import com.aluraDesafio.Libros.Service.ConsultaGemini;
import jakarta.persistence.*;

@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
    private String idioma;
    private int numeroDescargas;

public Libro(){

}
    public Libro(DatosLibro datosLibro, Autor autor) {
        this.titulo = datosLibro.titulo();
        this.idioma = String.join(", ", datosLibro.idioma());
        this.numeroDescargas = datosLibro.numeroDescargas();
        this.autor = autor;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(int numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }


    @Override
    public String toString() {
        return "\n Título: " + titulo +
                "\n Autor: " + (autor != null ? autor.getNombre() : "Sin autor") +
                "\n Idioma: " + idioma +
                "\n Descargas: " + numeroDescargas +
                "\n";
    }

}
