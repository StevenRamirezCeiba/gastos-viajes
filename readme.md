#### Especificaciones técnicas: 

 - Spring boot 2.5.2
 - Flayway -> administrar todos los script DDL e iniciliazadores de la bd 
 - Acceso a la base de datos por medio de JDBC template
 - Java 8
 - Se debe tener configurado el IDE con Lombok, descargar desde (https://projectlombok.org/download)
 - Se maneja la base de datos MySql
 

#### Importar el proyecto:
Para importar el proyecto se recomienda usar Gradle en la versión 5.0, se debe importar desde la ruta *microservicio/build.gradle*

#### Crear base de datos de Mysql:
Para que el proyecto arranque correctamente es necesario configurar el username y contraseña de nuestra conexion de Mysql. Para esto es necesario ir a la siguiente ruta:

src > main > resources > application.yaml

donde debemos modificar las propiedades username y password de spring:datasource

Por ultimo es necesario crear una nueva base de datos con el nombre "gastos_viajes"

#### Comandos Gradle:

Los siguientes comandos se pueden ejecutar en linea de comandos:

- gradlew bootRun (ejecutar el proyecto)
- gradlew build (compilar el proyecto)
- gradlew test (ejecuta las pruebas automaticas del proyecto)

Nota: En caso de abrir una terminal de powershell se ejecutan con el comando "./gradlew"


#### Endpoints:

La ruta para generar el reporte de los gastos de viajes de los empleados es el siguiente

http://localhost:8081/gastos-viajes/reporte-gasto-viaje

Da como respuesta un objeto de tipo Json con un atributo valorTotalGastos el cual es el valor total acumulado de los gastos de todos los 
empleados y tambien una lista de objetos en donde se especifica el gasto que tuvo el empleado por mes y quien asume el pago de dicho gasto.


Hash de git relacionado: 6b3f1d94