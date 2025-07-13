package com.aluraDesafio.Libros.Principal;

import com.aluraDesafio.Libros.Modelos.*;
import com.aluraDesafio.Libros.Repository.AutorRepository;
import com.aluraDesafio.Libros.Repository.LibroRepository;
import com.aluraDesafio.Libros.Service.ConsumoApi;
import com.aluraDesafio.Libros.Service.ConvierteDatos;


import java.util.*;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
   private ConsumoApi consumoApi = new ConsumoApi();
   private ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_INICIAL = "https://gutendex.com/books/";
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private LibroRepository repositorio;
    private AutorRepository repositorioo;
    private List<Libro> libros;
    private List<Autor> autores;


    public Principal (LibroRepository repository, AutorRepository repositoryy){
        this.repositorio = repository;
        this.repositorioo = repositoryy;
    }

    public void muestraMenu(){
        var opcion = -1;
        while (opcion !=0){
            var menu = """
                    **************************************
                    1 - Buscar libro por titulo
                    2 - Buscar libros por autores
                    3 - Listar libros registrados
                    4 - Listar autores registrados 
                    5 - Listar autores vivos en un determinado año
                    6 - Listar libros por idioma 
                    7 - Estadisticas de autor más longevo
                    8 - Top 10 libros más descargados 
                    
                    0 - Salir 
                    ***************************************
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    buscarLibroWeb();
                    break;
                case 2:
                    buscarAutorPorLibro();
                    break;
                case 3:
                    mostrarLibroBuscados();
                    break;
                case 4:
                    autoresRegistrados();
                    break;
                case 5:
                    autoresPorAnio();
                    break;
                case 6:
                    librosPorIdioma();
                    break;
                case 7:
                    estadisticasPorEdad();
                    break;
                case 8:
                    top10();
                    break;    
                case 0:
                    System.out.println("Cerrando aplicación");
                    break;
                default:
                    System.out.println("Opción Invalida");
            }
        }
    }



    private DatosLibro getDatosLibro() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "+"));

        Resultado resultado = conversor.obtenerDatos(json, Resultado.class);

        if (!resultado.resultados().isEmpty()) {
            return resultado.resultados().get(0); // solo el primero
        } else {
            System.out.println("No se encontró el libro.");
            return null;
        }
    }



    private void buscarLibroWeb() {
        // Obtener los datos del libro desde la API
        DatosLibro datos = getDatosLibro();

        // Validar que los datos existan
        if (datos == null || datos.autor().isEmpty()) {
            System.out.println(" No se encontró el libro o no tiene autores.");
            return;
        }

        // Verificar si el libro ya existe en la base de datos
        Optional<Libro> libroExistente = repositorio.findByTituloContainingIgnoreCase(datos.titulo());
        if (libroExistente.isPresent()) {
            System.out.println("Este libro ya está registrado en la base de datos.");
            return;
        }

        // Tomar el primer autor del libro
        var datosAutor = datos.autor().get(0);

        // Buscar si ya existe ese autor en la base
        Optional<Autor> autorExistente = repositorioo.findByNombreIgnoreCase(datosAutor.nombre());

        Autor autor;
        if (autorExistente.isPresent()) {
            autor = autorExistente.get(); // Ya existe, lo usamos
        } else {
            autor = new Autor(datosAutor); // No existe, lo creamos
            autor = repositorioo.save(autor); // Guardamos el nuevo autor
        }

        // Crear y guardar el libro con su autor
        Libro libro = new Libro(datos,autor);
        libro.setAutor(autor);
        repositorio.save(libro);

        System.out.println("Libro guardado correctamente:\n" + libro);
    }

    private void mostrarLibroBuscados(){
        libros = repositorio.findAll();
        libros.forEach(System.out::println);
    }

    private void buscarAutorPorLibro() {
        System.out.println("Escribe el nombre del autor que quieres buscar");
        var nombreAutor = teclado.nextLine();

        List<Libro> librosDelAutor = repositorio.findByAutorNombreIgnoreCaseContaining(nombreAutor);

        if (librosDelAutor.isEmpty()) {
            System.out.println("No se encontraron libros de ese autor.");
        } else {
            librosDelAutor.forEach(System.out::println);
        }
    }

    private void autoresRegistrados() {
        autores = repositorioo.findAll();
        autores.forEach(System.out::println);
    }

    private void autoresPorAnio(){
        System.out.println("Escribe el año que deseas buscar");
        var anio = teclado.nextInt();
        List<Autor> autoresPorAnio = repositorioo.findByAnio(anio);
        autoresPorAnio.forEach(a -> System.out.println("Nombre autor: "+a.getNombre()+"\nNacimiento: "+a.getNacimiento()));
    }

    private void librosPorIdioma() {
        System.out.println("Escribe las siglas por las cuales quieres burcar un libro");
        System.out.println("Ingles(EN),Frances(FR),Español(ES),Japones(JA),Aleman(DE),Italiano(IT)");
        var idiomaDelLibro = teclado.nextLine().toLowerCase();
        List<Libro> libroPorIdioma = repositorio.findByIdioma(idiomaDelLibro);

        if (libroPorIdioma.isEmpty()){
            System.out.println("Idioma no encontrado");
        }else {
            libroPorIdioma.forEach(System.out::println);
        }
    }

    private void estadisticasPorEdad() {
        autoresRegistrados();
        Optional<Autor> masEdad = autores.stream()
                .filter(a -> a.getNacimiento() != 0 && a.getFallecimiento() != 0)
                .max(Comparator.comparing(a -> a.getFallecimiento() - a.getNacimiento()));

        if (masEdad.isPresent()){
            Autor autor = masEdad.get();
            int edad = autor.getFallecimiento() - autor.getNacimiento();
            System.out.println("****************");
            System.out.println("Autor más longevos");
            System.out.println("Nombre: "+autor.getNombre()+" Edad: "+edad+" años");
        }else {
            System.out.println("No se encontro ningun autor con fechas validas");
        }
    }

    private void top10() {
        List<Libro> topLibros = repositorio.findTop10ByOrderByNumeroDescargasDesc();
        topLibros.forEach(l -> System.out.println("Libro: "+l.getTitulo()+" Descargas: "+l.getNumeroDescargas()));
    }







}













