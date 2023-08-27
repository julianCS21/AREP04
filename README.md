# TALLER 2: TALLER DISEÑO Y ESTRUCTURACIÓN DE APLICACIONES DISTRIBUIDAS EN INTERNET


Programa creado para que el usuario pueda visualizar y usar los archivos locales del servidor.


### Prerequisitos

Para elaborar este proyecto se requirio de : 


Maven: Apache Maven es una herramienta que maneja el ciclo de vida del programa.



Git: Es un sistema de control de versiones distribuido (VCS).



Java 19: Java es un lenguaje de programación de propósito general orientado a objetos, portátil y muy versátil.



### Instalación

Clonamos el repositorio

```
    git clone https://github.com/julianCS21/taller02AREP.git

```
Se accede a la carpeta principal del repositorio repositorio que acabamos de clonar

	 cd taller02AREP

Hacemos la construccion del proyecto

	 mvn package
---
### Corriendo
Corremos los siguientes comando
	
	 mvn clean package install
	 mvn clean install

Ahora corremos el servidor
	
**Windows**

	 mvn exec:java -"Dexec.mainClass"="edu.escuelaing.arep.ASE.app.HTTPserver.webServer"

**Linux/MacOs**

	 mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.ASE.app.HTTPserver.webServer"

Por ultimo accedemos a nuestro navegador de confianza con la siguiente URL

	 http://localhost:35000/

Aqui nos debera de cargar la siguiente pagina, con la cual podemos empezar a hacer las busquedas que necesitemos

![image](https://github.com/julianCS21/taller02AREP/assets/96396177/6bcb8006-784b-4085-9b67-12c1c0deb746)

# Documentos HTML

![image](https://github.com/julianCS21/taller02AREP/assets/96396177/158d1eba-b6ce-41e7-9d63-cb478f20e1ba)

# Documentos CSS

![image](https://github.com/julianCS21/taller02AREP/assets/96396177/08cdea3f-f442-427a-b9fc-d3228f3415ab)

# Documentos JS

![image](https://github.com/julianCS21/taller02AREP/assets/96396177/b1093448-1013-4ddf-b737-fcdefb883195)


# Documentos JPG

![image](https://github.com/julianCS21/taller02AREP/assets/96396177/170a0e46-6a65-4f36-b1de-4b32e047eb59)



# Documentos aplicacion HTML CSS Y JS

![image](https://github.com/julianCS21/taller02AREP/assets/96396177/bdd3105e-61aa-472e-ab11-08eafcb3bd7e)

# Aplicacion de servicio REST

![image](https://github.com/julianCS21/taller02AREP/assets/96396177/66d150d0-ff92-40a8-a99c-689893c6ab15)




---
### Corriendo test

Ejecutamos el comando

	mvn test
	
---


### Diseño del programa.



El programa consta de cuatro componentes principales:

1. **JS Web Client (Cliente Web en JavaScript):** Representado en la carpeta "views", este cliente es la interfaz de nuestra aplicación. Realiza consultas asincrónicas mediante solicitudes GET utilizando promesas.

2. **Web Server with REST API Facade (Servidor Web con Fachada de API REST):** Dividido en tres carpetas.

   - **WebServer (Servidor Web):** Codifica el servidor que recibe las solicitudes del cliente.
   
   - **Controllers (Controladores):** Actúan como intermediarios entre los servicios y el servidor web. Se centran en el recurso "films".
   
   - **Services (Servicios):** Contiene la lógica del backend. Implementa la lógica necesaria para proporcionar las respuestas requeridas por el cliente.

3. **External REST API (API REST Externa):** Representa servicios web externos a los cuales se accede para obtener información sobre el recurso "films".

4. **Concurrent Java Test Client (Cliente de Pruebas Java Concurrente):** Una clase en Java responsable de probar las funcionalidades del backend de la fachada de manera concurrente a través de hilos. Se encuentra en la carpeta "test".




Para extender la funcionalidad de nuestro backend, hemos implementado una interfaz que define las funcionalidades y una clase que la implementa. Esta estructura nos permite agregar nuevas funciones simplemente extendiendo la interfaz existente.




Cuando deseamos añadir más servicios web externos, utilizamos una interfaz de fábrica que devuelve instancias de los servicios web necesarios. Cada nuevo servicio web debe implementar esta interfaz de fábrica. También hemos implementado una interfaz con los métodos que deben ser implementados por los servicios web externos.




## Construido con

* [Maven](https://maven.apache.org/): Apache Maven es una herramienta que estandariza la configuración del ciclo de vida del proyecto.
* [Git](https://rometools.github.io/rome/):  Es un sistema de control de versiones distribuido (VCS).
* [Visual Studio Code](https://code.visualstudio.com): es un editor de código fuente desarrollado por Microsoft.
* [Java 19](https://www.java.com/es/): Lenguaje de programación de propósito general con enfoque a el paradigma de orientado a objetos, y con un fuerte tipado de variables.
* [Html](https://developer.mozilla.org/es/docs/Learn/Getting_started_with_the_web/HTML_basics): es un lenguaje de marcado que estructura una página web y su contenido.
* [JavaScript](https://developer.mozilla.org/es/docs/Learn/JavaScript/First_steps/What_is_JavaScript): lenguaje de programación que los desarrolladores utilizan para hacer paginas web dinamicas.


## Autor
* **[Julián David Castillo Soto](https://www.linkedin.com/in/julián-david-castillo-soto-118856216/)**  - [julianCS21](https://github.com/julianCS21)

## Licencia
**©** Julián David Castillo Soto, Estudiante de Ingeniería de Sistemas de la Universidad Escuela Colombiana de Ingeniería Julio Garavito.
