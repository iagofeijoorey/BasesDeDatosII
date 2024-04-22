-- TIPOS DE MIEMBROS EN LA SECTA
CREATE table if not exists Acólitos (

	alias VARCHAR(15) NOT NULL,
	nombreCompleto VARCHAR(30) not null,
	fechaIngreso DATE default CURRENT_DATE,
	telefono integer not null,
	direccion VARCHAR(50) not null,
	influencia INTEGER default 0,
	dinero DECIMAL(10,2) default 0,
	contraseña VARCHAR(15) not null,
	primeraEntrada BOOLEAN DEFAULT true, -- Esto para que de primeras salga el contrato inicial (luego ya lo cambiamos a FALSE)

primary key(alias)
);

CREATE TABLE if not exists Cabecillas (

	alias VARCHAR(15),		
	
	primary key (alias),
	FOREIGN KEY (alias) REFERENCES Acólitos(alias)
	  on delete cascade on update cascade
	
);

CREATE table if not exists Jefes_de_division (

	alias VARCHAR(15),
	nombreDivision VARCHAR(50),
	
	PRIMARY KEY (alias),
	FOREIGN KEY (alias) REFERENCES Acólitos(alias)
	 on delete cascade on update cascade
	
);

CREATE TABLE if not exists Miembros_basicos (

	alias VARCHAR(15) NOT NULL,
	jefe VARCHAR(15),
	
	PRIMARY KEY (alias),
	FOREIGN KEY (alias) REFERENCES Acólitos(alias)
		on delete cascade on update cascade,
	FOREIGN KEY (jefe) REFERENCES Jefes_de_division(alias)
		on delete cascade on update cascade

);

CREATE TABLE if not exists Gestor_interno (

	alias VARCHAR(15),
	
	PRIMARY KEY (alias),
	FOREIGN KEY (alias) REFERENCES Jefes_de_division(alias)
	  on delete cascade on update cascade

);

CREATE TABLE if not exists Guia_espiritual (

	alias VARCHAR(15),
	
	PRIMARY KEY (alias),
	FOREIGN KEY (alias) REFERENCES Jefes_de_division(alias)
	   on delete cascade on update cascade
	
);

CREATE TABLE if not exists Contactos (

	pseudonimo VARCHAR(15) NOT NULL,
	nombre VARCHAR(30) not null,
	telefono integer not null,
	descripcion text,
	
	PRIMARY KEY (pseudonimo)
);

-- PROPIEDADES DE LA SECTA

CREATE TABLE  if not exists Propiedades (

	idPropiedad INT NOT NULL,
	valor_actual DECIMAL(10,2) not null,
	gestor VARCHAR(15),
	
	PRIMARY KEY (idPropiedad),
	FOREIGN KEY (gestor) REFERENCES Gestor_interno(alias)
		on delete RESTRICT on update cascade

);

CREATE TABLE if not exists Cuentas (

	IBAN VARCHAR(34) NOT NULL,
	cantidad DECIMAL(10,2) not null,
	divisa VARCHAR(5) default 'Euro' not null,
	gestor VARCHAR(15),
	
	PRIMARY KEY (IBAN),
	FOREIGN KEY (gestor) REFERENCES Gestor_interno(alias)
	   on delete RESTRICT on update cascade
	
);

CREATE TABLE if not exists Commodities (

	idPropiedad INT,
	nombre VARCHAR(30) not null,
	cantidad INT not null,
	
	PRIMARY KEY (idPropiedad),
	FOREIGN KEY (idPropiedad) REFERENCES Propiedades(idPropiedad)
	   on delete cascade on update cascade

);

CREATE TABLE if not exists Inmobiliario (

	idPropiedad INT,
	ubicacion VARCHAR(100) not null,
	tipoInmobiliario VARCHAR(50) not null,
	
	PRIMARY KEY (idPropiedad),
	FOREIGN KEY (idPropiedad) REFERENCES Propiedades(idPropiedad)
		on delete cascade on update cascade

);

CREATE TABLE if not exists Almacenes (

	idPropiedad INT,
	capacidad INT not null,
	
	PRIMARY KEY (idPropiedad),
	FOREIGN KEY (idPropiedad) REFERENCES Inmobiliario(idPropiedad)
		on delete cascade on update cascade

);

CREATE TABLE if not exists Vehiculos (

	idPropiedad INT,
	tipoVehiculo VARCHAR(30) not null,
	capacidad INT not null,
	almacén INT,
	
	PRIMARY KEY (idPropiedad),
	FOREIGN KEY (idPropiedad) REFERENCES Propiedades(idPropiedad)
		on delete cascade on update cascade,
	FOREIGN KEY (almacén) REFERENCES Almacenes(idPropiedad)
		on delete cascade on update cascade

);

CREATE TABLE if not exists Armas (

	idPropiedad INT,
	tipoArmamento VARCHAR(30) not null,
	cantidad INT not null,
	numBalas INT not null,
	almacén INT,
	
	PRIMARY KEY (idPropiedad),
	FOREIGN KEY (idPropiedad) REFERENCES Propiedades(idPropiedad)
		on delete cascade on update cascade,
	FOREIGN KEY (almacén) REFERENCES Almacenes(idPropiedad)
		on delete cascade on update cascade
	
);

-- RELACIONES ENTRE ACÓLITOS Y CONTACTOS

CREATE TABLE if not exists Tratos (
	
	idTrato INT NOT NULL,
	tipoTrato VARCHAR(100) not null,
	contacto VARCHAR(15),
	acólito VARCHAR(15),
	
	PRIMARY KEY (idTrato, contacto, acólito),
	FOREIGN KEY (contacto) REFERENCES Contactos(pseudonimo)
		on delete RESTRICT on update cascade,
	FOREIGN KEY (acólito) REFERENCES Acólitos(alias)
		on delete cascade on update cascade
	
);

CREATE TABLE if not exists SerSoloContacto (
	
	contacto VARCHAR(15),
	acólito VARCHAR(15),
	
	PRIMARY KEY (contacto, acólito),
	FOREIGN KEY (contacto) REFERENCES Contactos(pseudonimo)
		on delete cascade on update cascade,
	FOREIGN KEY (acólito) REFERENCES Acólitos(alias)
		on delete cascade on update cascade
	
);

-- RELACIÓN ENTRE ACÓLITOS Y GUÍA ESPIRITUAL

CREATE TABLE if not exists Ritos (

	idRito INT NOT NULL,
	tipoRito VARCHAR(20) not null,
	acólito VARCHAR(15),
	guiaEspiritual VARCHAR(15),
	fechaHora TIMESTAMP not null,
	
	PRIMARY KEY (idRito, guiaEspiritual, acólito),
	FOREIGN KEY (acólito) REFERENCES Acólitos(alias)
		on delete cascade on update cascade,
	FOREIGN KEY (guiaEspiritual) REFERENCES Guia_espiritual(alias)
		on delete RESTRICT on update cascade

);

-- TABLAS RELACIONADAS CON LOS EVENTOS QUE LA SECTA ORGANIZA

CREATE TABLE if not exists Eventos (

	ubicacion VARCHAR(100) NOT NULL,
	fecha DATE NOT NULL,
	tipoEvento VARCHAR(100) not null,
	descripcion TEXT,
	autorizador VARCHAR(50),
	organizador VARCHAR(50),
	
	PRIMARY KEY (ubicacion, fecha),
	FOREIGN KEY (autorizador) REFERENCES Cabecillas(alias)
		on delete cascade on update cascade,
	FOREIGN KEY (organizador) REFERENCES Jefes_de_division(alias)
		on delete RESTRICT on update cascade

);

CREATE TABLE if not exists Objetivos (

	idObjetivo INT NOT NULL,
	ubicacion VARCHAR(100) not null,
	fecha DATE not null,
	descripción TEXT,
	prioridad INT not null,
	
	PRIMARY KEY (idObjetivo, ubicacion, fecha),
	FOREIGN KEY (ubicacion, fecha) REFERENCES Eventos(ubicacion, fecha)
		on delete cascade on update cascade

);

CREATE TABLE if not exists ProporcionarApoyo (

	jefe VARCHAR(15),
	ubicacion VARCHAR(255),
	fecha DATE,
	
	PRIMARY KEY (jefe, ubicacion, fecha),
	FOREIGN KEY (jefe) REFERENCES Jefes_de_division (alias)
		on delete cascade on update cascade,
	FOREIGN KEY (ubicacion, fecha) REFERENCES Eventos (ubicacion, fecha)
		on delete cascade on update cascade
	
);

CREATE TABLE if not exists PropiedadesUsadas (

	idPropiedad INT,
	ubicacion VARCHAR(255),
	fecha DATE,
	
	PRIMARY KEY (idPropiedad, ubicacion, fecha),
	FOREIGN KEY (idPropiedad) REFERENCES Propiedades (idPropiedad)
		on delete cascade on update cascade,
	FOREIGN KEY (ubicacion, fecha) REFERENCES Eventos (ubicacion, fecha)
		on delete cascade on update cascade

);

CREATE TABLE if not exists Recompensas_Dinero (

	idRecompensa INT NOT NULL,
	dinero DECIMAL(10,2),
	
	PRIMARY KEY (idRecompensa)

);

CREATE TABLE if not exists Recompensas_Influencia (

	idRecompensa INT NOT NULL,
	influencia INTEGER not null,
	PRIMARY KEY (idRecompensa)

);

CREATE TABLE if not exists Recompensas_Contacto (

	idRecompensa INT NOT NULL,
	contacto VARCHAR(15),
	
	PRIMARY KEY (idRecompensa),
	FOREIGN KEY (contacto) REFERENCES Contactos (pseudonimo)
		on delete cascade on update cascade

);
