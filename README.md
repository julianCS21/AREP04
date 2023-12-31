# TALLER 4: TALLER DE ARQUITECTURAS DE SERVIDORES DE APLICACIONES, META PROTOCOLOS DE OBJETOS, PATRÓN IOC, REFLEXIÓN


Programa creado para simular el microframework Spring a traves de reflexiónes que ofrece Java.

### Prerequisitos

Para elaborar este proyecto se requirio de : 


Maven: Apache Maven es una herramienta que maneja el ciclo de vida del programa.



Git: Es un sistema de control de versiones distribuido (VCS).



Java 17: Java es un lenguaje de programación de propósito general orientado a objetos, portátil y muy versátil.



### Instalación

Clonamos el repositorio

```
    git clone 

```
Se accede a la carpeta principal del repositorio repositorio que acabamos de clonar

	 cd AREP04

Hacemos la construccion del proyecto

	 mvn package
---
### Corriendo
Corremos los siguientes comando
	
	 mvn clean package install
	 mvn clean install

Ahora corremos el servidor
	
**Windows**

	 java -cp "target\classes" edu.escuelaing.arep.ASE.app.main


**Linux/MacOs**

	 java -cp target/classes edu.escuelaing.arep.ASE.app.main


Por ultimo accedemos a nuestro navegador de confianza con la siguiente URL

	 http://localhost:35000/

Aqui nos debera de cargar la siguiente pagina, con la cual podemos empezar a hacer las busquedas que necesitemos

![image](https://github.com/julianCS21/taller02AREP/assets/96396177/6bcb8006-784b-4085-9b67-12c1c0deb746)

# Documentos HTML

![image](https://github.com/julianCS21/taller02AREP/assets/96396177/158d1eba-b6ce-41e7-9d63-cb478f20e1ba)



# Documentos PNG

![image](https://github.com/julianCS21/AREP04/assets/96396177/694244b8-eeee-4561-a98b-9a31f59f6efb)








# ¿Como el desarrollador crearia una aplicacion con este marco de trabajo?


Es simple, considere los siguientes pasos

1. Cree una clase dentro del los archivos edu.escuelaing.arep.ASE.app

   ![image](https://github.com/julianCS21/AREP04/assets/96396177/5941d148-b0e6-4085-a1a9-eaae581d10af)


2. Cree los metodos que considere necesarios, pero a su vez percatese de colocar la etiqueta RequestMapping(cabe aclarar que deben ser static y deben retornar string)

   ![image](https://github.com/julianCS21/AREP04/assets/96396177/1856cc79-be9c-4b56-b674-09e14a53ff95)


3. corra el servidor y revise que desde el navegador funcione lo implementado

   ![image](https://github.com/julianCS21/AREP04/assets/96396177/7257ab60-97a1-4109-899c-0db57a8edb65)


---
### Corriendo test

Ejecutamos el comando

	mvn test
	
---





## Construido con

* [Maven](https://maven.apache.org/): Apache Maven es una herramienta que estandariza la configuración del ciclo de vida del proyecto.
* [Git](https://rometools.github.io/rome/):  Es un sistema de control de versiones distribuido (VCS).
* [Intellj](https://www.jetbrains.com/es-es/idea/): IntelliJ IDEA es un IDE que ayuda a los desarrolladores a escribir, depurar y administrar código de manera más eficiente y efectiva, con muchas características que facilitan el proceso de desarrollo de software.
* [Java 19](https://www.java.com/es/): Lenguaje de programación de propósito general con enfoque a el paradigma de orientado a objetos, y con un fuerte tipado de variables.
* [Html](https://developer.mozilla.org/es/docs/Learn/Getting_started_with_the_web/HTML_basics): es un lenguaje de marcado que estructura una página web y su contenido.
* [JavaScript](https://developer.mozilla.org/es/docs/Learn/JavaScript/First_steps/What_is_JavaScript): lenguaje de programación que los desarrolladores utilizan para hacer paginas web dinamicas.
* [CSS](https://developer.mozilla.org/es/docs/Web/CSS) Lenguaje para darles estilos a paginas web.


## Autor
* **[Julián David Castillo Soto](https://www.linkedin.com/in/julián-david-castillo-soto-118856216/)**  - [julianCS21](https://github.com/julianCS21)

## Licencia
**©** Julián David Castillo Soto, Estudiante de Ingeniería de Sistemas de la Universidad Escuela Colombiana de Ingeniería Julio Garavito.
