CREATE DATABASE inmuebles_db;

CREATE TABLE persona(
	id int NOT NULL auto_increment,
	nombre VARCHAR(100) NOT NULL, 
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    
);

CREATE TABLE inmueble(
	id int NOT NULL auto_increment,
	direccion VARCHAR(100) NOT NULL, 
    ciudad VARCHAR(50) NOT NULL, 
    departamento VARCHAR(50) NOT NULL, 
    barrio VARCHAR(50) NOT NULL, 
    PRIMARY KEY (id)
    
);

CREATE TABLE contrato(
	idPersona INT NOT NULL,
    idInmueble INT NOT NULL,
    numeroContrato INT NOT NULL,
    fecha DATE NOT NULL,
    estado VARCHAR(50) NOT NULL,
    CONSTRAINT pk_contrato PRIMARY KEY (numeroContrato, idPersona, idInmueble),
    FOREIGN KEY (idPersona) REFERENCES persona(id)  ON DELETE CASCADE,
    FOREIGN KEY (idInmueble) REFERENCES inmueble(id)  ON DELETE CASCADE
);


INSERT INTO persona(nombre, apellido, correo)
VALUES('Yohel', 'Perez', 'perezyohel@gmail.com');

INSERT INTO persona(nombre, apellido, correo)
VALUES('Juan', 'Diaz', 'juan.diaz@gmail.com');

INSERT INTO persona(nombre, apellido, correo)
VALUES('Camila', 'Botero', 'cami.botero@gmail.com');

INSERT INTO inmueble(direccion, ciudad, departamento, barrio)
VALUES('cararera 42 #31-10', 'Envigado', 'Antioquia', 'Mesa');

INSERT INTO inmueble(direccion, ciudad, departamento, barrio)
VALUES('cararera 41 F #20-21', 'Bello', 'Antioquia', 'Cabañas');


INSERT INTO contrato(idPersona, idInmueble, fecha, estado)
VALUES( 1, 1, '2021-06-11', 'Vigente');

INSERT INTO contrato(idPersona, idInmueble, fecha, estado)
VALUES( 2, 2, '2018-03-21', 'No Vigente');

INSERT INTO contrato(idPersona, idInmueble, fecha, estado)
VALUES( 3, 2, '2019-08-16', 'Vigente');



/*SELECT p.nombre, p.apellido, p.correo, i.direccion, i.ciudad, i.departamento, i.barrio, c.fecha, c.estado
FROM persona as p
INNER JOIN contrato as c on c.idPersona = p.id
INNER JOIN inmueble as i on i.id = c.idInmueble
WHERE p.nombre LIKE 'Yohel' OR p.apellido LIKE 'Yohel' OR p.correo LIKE 'Yohel';
*/




