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
    PRIMARY KEY (id)
    
);

CREATE TABLE contrato(
	idPersona INT NOT NULL,
    idInmueble INT NOT NULL,
    numeroContrato INT NOT NULL,
    fecha DATE NOT NULL,
    CONSTRAINT pk_contrato PRIMARY KEY (numeroContrato, idPersona, idInmueble),
    FOREIGN KEY (idPersona) REFERENCES persona(id)  ON DELETE CASCADE,
    FOREIGN KEY (idInmueble) REFERENCES inmueble(id)  ON DELETE CASCADE
);




INSERT INTO barber_appointment_db.barber(email, name, phone, time_in, time_out)
VALUES('pepitoperez@gmail.com', 'pepito perez', '3006005252', '8:00', '17:00');

INSERT INTO inmueble(direccion, ciudad, departamento, barrio)
VALUES('cararera 42 #31-10', 'Envigado', 'Antioquia', 'El mesa');

UPDATE inmueble
SET ciudad= 'Medellin', departamento= 'Antioquia', barrio = 'Robledo'
WHERE id= '1';


-- contrato

UPDATE contrato
SET estado= 'Vigente'
WHERE numeroContrato= '3';

ALTER TABLE contrato
add estado varchar(50) NOT NULL;

INSERT INTO contrato(idPersona, idInmueble, fecha)
VALUES( 2, 1, '2021-09-12');

SELECT * FROM contrato;

SELECT p.nombre, p.apellido, p.correo, i.direccion, i.ciudad, i.departamento, i.barrio, c.fecha
FROM persona as p
INNER JOIN contrato as c on c.idPersona = p.id
INNER JOIN inmueble as i on i.id = c.idInmueble; 

desc contrato;




