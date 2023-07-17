## Inmuebles-api

### Preview
![image](https://github.com/yohelperez/inmuebles-api/assets/55060788/6ffa8adc-8d52-4925-8016-b098c3ef95bb)

Inmuebles-api es una aplicación web que brinda un servicio para consultar el registro de propiedades que han sido habitadas por varias personas. Permite almacenar información sobre personas, direcciones y bienes inmuebles, y proporciona una interfaz para buscar personas y sus respectivas direcciones asociadas.

### Tecnología usada
* Java 8 (Servlets y api)
* mysql
* javascript
* HTML
* CSS

### Requisitos

* Java (JDK) 8 o superior.
* Servidor MySQL.
* Un servidor de aplicaciones web compatible (por ejemplo, Apache Tomcat).

### Configuración de la base de datos
* Crear una base de datos MySQL con el nombre "inmuebles_db".
* Ejecute el script database.sql (ubicado en el paquete "resources") para crear las tablas necesarias.

### Configuración del proyecto
* Clone este repositorio en su máquina local.
* Importe el proyecto a su entorno de desarrollo Java (por ejemplo, IntelliJ IDEA).
* Configure las credenciales de la base de datos en el archivo DBConnection.java ubicado en src/main/java/com/example/inmueblesapi/model/DBConexion/.
* Implemente la aplicación en su servidor de aplicaciones web (por ejemplo, Apache Tomcat).
