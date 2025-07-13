package com.aluraDesafio.Libros;

import com.aluraDesafio.Libros.Principal.Principal;
import com.aluraDesafio.Libros.Repository.AutorRepository;
import com.aluraDesafio.Libros.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibrosApplication implements CommandLineRunner {
	@Autowired
	private LibroRepository repository;
	@Autowired
	private AutorRepository repositoryy;


	public static void main(String[] args) {
		SpringApplication.run(LibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository,repositoryy);
		principal.muestraMenu();
	}
}
