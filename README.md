📚 EXPLORADOR DE LIBROS CON GUTENDEX

Aplicación en consola desarrollada con Java 17 y Spring Boot, que permite consultar, registrar y explorar información de libros y autores desde la API pública de Gutendex.

🚀 Tecnologías Utilizadas
Java 17

-Spring Boot 3

-Spring Data JPA + Hibernate

-HTTPClient (consumo API)

-Gson (conversión de JSON a objetos)

-Gemini (opcional para traducción de sinopsis)

Base de datos PostGress

⚙️ ¿Cómo ejecutar?
-Clona el repositorio.

-Configura la base de datos en application.properties

-Ejecuta la clase LibrosApplication.

-Desde consola, navega el menú con las opciones del sistema.


<img width="424" height="269" alt="image" src="https://github.com/user-attachments/assets/b57446ca-cc1f-4bba-852c-86749302a939" />

🧭 Funcionalidades del Menú
1️⃣ Buscar libro por título
Consulta el título en Gutendex, guarda el libro y su autor en la base de datos.

<img width="817" height="291" alt="image" src="https://github.com/user-attachments/assets/41c791b0-6356-4ba4-81a8-df3aec9b17a4" />



2️⃣ Buscar libros por autor
Muestra los libros registrados para un autor específico.

<img width="834" height="358" alt="image" src="https://github.com/user-attachments/assets/8170bfdd-0f76-4a1c-a726-b2948a8fcfc7" />



3️⃣ Listar libros registrados
Imprime en consola todos los libros almacenados en la base.

<img width="813" height="537" alt="image" src="https://github.com/user-attachments/assets/1483831a-28b7-4249-b5cb-31073dcb02fd" />



4️⃣ Listar autores registrados
Muestra todos los autores registrados en la base.

<img width="848" height="395" alt="image" src="https://github.com/user-attachments/assets/157e7c25-d0c2-4215-b73c-1c655bf05b91" />



5️⃣ Listar autores vivos en un determinado año
Filtra autores que estaban vivos en el año especificado por el usuario.

<img width="770" height="533" alt="image" src="https://github.com/user-attachments/assets/f86dc451-5430-49a2-b322-d76952ed3bee" />



6️⃣ Listar libros por idioma
Permite buscar libros por código de idioma (EN, FR, ES, etc.).

<img width="664" height="262" alt="image" src="https://github.com/user-attachments/assets/d2cec5e4-7a50-41be-92f5-f0f27b2a3b53" />



7️⃣ Estadística: autor más longevo
Muestra el autor con mayor edad al fallecer (según años de nacimiento y muerte).

<img width="820" height="442" alt="image" src="https://github.com/user-attachments/assets/783c9987-8677-4db8-9620-7065b0a27481" />



8️⃣ Top 10 libros más descargados
Lista los 10 libros con más descargas registradas.

<img width="664" height="491" alt="image" src="https://github.com/user-attachments/assets/31e87e42-9be4-4104-8ab3-05a6f7e25151" />



📁 Estructura del Proyecto

📦 src
 ┣ 📂 main
 ┃ ┣ 📂 java
 ┃ ┃ ┣ 📂 com.aluraDesafio.Libros
 ┃ ┃ ┃ ┣ 📂 Modelos          # Clases Autor y Libro (entidades JPA)
 ┃ ┃ ┃ ┣ 📂 Repository       # Interfaces AutorRepository y LibroRepository
 ┃ ┃ ┃ ┣ 📂 Service          # ConsumoApi y ConvierteDatos
 ┃ ┃ ┃ ┣ 📂 Principal        # Clase Principal (menú principal)
 ┃ ┃ ┃ ┗ LibrosApplication  # Main class
 ┣ 📂 resources
 ┃ ┗ application.properties

💡 Notas
*Si el autor ya está en la base, se reutiliza (no se duplica).

*Si no hay sinopsis, se guarda un mensaje predeterminado.

*El sistema evita guardar libros duplicados.

*Permite hasta 6 idiomas predefinidos, mapeados con un enum.

🧪 Recomendaciones para pruebas
-Puedes insertar manualmente libros desde consola.

-Asegúrate de tener conexión a internet para el consumo de la API de Gutendex.

-Si usas Gemini para sinopsis, asegúrate de tener tu clave de API activa.

🙋‍♀️ Autora
Proyecto creado por Ninel Quezada Hernández como parte del desafío de Alura LATAM.
