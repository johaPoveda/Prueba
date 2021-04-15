Prueba tecnica - Cindy Johana López poveda
----------------------------------------------------
Introducción:
El proposito de esta prueba es automatizar el flujo de contactanos en la página web http://automationpractice.com/index.php.
Dentro de esta automatización se realiza el proceso de completar la información,tomar captura de pantalla, validar mensaje esperado y generar reporte.

----------------------------------------------------
La automatización de este proyecto está construida con:

-Java 1.8
-Selenium
-Maven
-TestNG
-Chrome Driver
-Arquetipo POM
-JenkinsFile (para ejecución desde servidor jenkins)

----------------------------------------------------
La ejecución de este proyecto se puede hacer de dos maneras.

1- Ejecutando la clase EjecucionPagina.java como testNG que se encuentra en la ruta src/test/java/ejecucion.
2- Desde una terminal utilizando el comando [mvn test]


----------------------------------------------------
Las rutas para las evidencias y el reporte son

1- Evidencias: src/images
2- Reporte (en el informe está en un arcchivo plano) : src/reporter.txt 

----------------------------------------------------
Capturas del flujo automatizado

*Inicio
![ScreenShot](https://github.com/johaPoveda/Prueba/blob/master/src/images/1_incio.png)

*Página contactanos
![ScreenShot](https://github.com/johaPoveda/Prueba/blob/master/src/images/2_contactanos.png)

*Campos completados de contactanos
![ScreenShot](https://github.com/johaPoveda/Prueba/blob/master/src/images/3_campos%20contact%20us.png)

*Mensaje exitoso
![ScreenShot](https://github.com/johaPoveda/Prueba/blob/master/src/images/4_mesaje%20contacto%20exitoso.png)

