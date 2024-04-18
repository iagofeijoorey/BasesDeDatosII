
# Tipos de miembros en la secta
CREATE TABLE Acólitos (

    alias VARCHAR(50) NOT NULL PRIMARY KEY,
    nombreCompleto VARCHAR(60),
    lugarNacimiento VARCHAR(80),
    fechaIngreso DATE,
    telefono VARCHAR(20),
    direccion VARCHAR(255),
    influencia INTEGER,
    dinero DECIMAL(10,2),
    primeraEntrada BOOLEAN DEFAULT TRUE # Esto para que de primeras salga el contrato inicial (luego ya lo cambiamos a FALSE)

);

CREATE TABLE Cabecillas (

    alias VARCHAR(50) NOT NULL PRIMARY KEY,
    FOREIGN KEY (alias) REFERENCES Acólitos(alias)

);

CREATE TABLE Miembros_basicos (

    alias VARCHAR(50) NOT NULL,
    jefe VARCHAR(50),
    PRIMARY KEY (alias),
    FOREIGN KEY (alias) REFERENCES Acólitos(alias),
    FOREIGN KEY (jefe) REFERENCES Jefes_de_division(alias)

);

CREATE TABLE Jefes_de_division (

    alias VARCHAR(50) NOT NULL PRIMARY KEY,
    nombreDivision VARCHAR(100),
    FOREIGN KEY (alias) REFERENCES Acólitos(alias)

);

CREATE TABLE Gestor_interno (

    alias VARCHAR(50) NOT NULL PRIMARY KEY,
    FOREIGN KEY (alias) REFERENCES Jefes_de_division(alias)

);

CREATE TABLE Guia_espiritual (

    alias VARCHAR(50) NOT NULL PRIMARY KEY,
    FOREIGN KEY (alias) REFERENCES Jefes_de_division(alias)

);

CREATE TABLE Contactos (

    pseudonimo VARCHAR(50) NOT NULL PRIMARY KEY,
    nombre VARCHAR(100),
    telefono VARCHAR(20),
    descripcion TEXT

);

# Propiedades de la secta

CREATE TABLE Propiedades (

    idPropiedad INT NOT NULL PRIMARY KEY,
    Valor_actual DECIMAL(10,2),
    gestor VARCHAR(50),
    FOREIGN KEY (gestor) REFERENCES gestor_interno(alias)

);

CREATE TABLE Cuentas (

    IBAN VARCHAR(50) NOT NULL PRIMARY KEY,
    cantidad DECIMAL(10,2),
    divisa VARCHAR(3),
    gestor VARCHAR(50),
    FOREIGN KEY (gestor) REFERENCES gestor_interno(alias)

);

CREATE TABLE Commodities (

    idPropiedad INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(100),
    cantidad INT,
    FOREIGN KEY (idPropiedad) REFERENCES Propiedades(idPropiedad)

);

CREATE TABLE Inmobiliario (

    idPropiedad INT NOT NULL PRIMARY KEY,
    ubicacion VARCHAR(255),
    tipoInmobiliario VARCHAR(100),
    FOREIGN KEY (idPropiedad) REFERENCES Propiedades(idPropiedad)

);

CREATE TABLE Almacenes (

    idPropiedad INT NOT NULL PRIMARY KEY,
    capacidad INT,
    FOREIGN KEY (idPropiedad) REFERENCES Inmobiliario(idPropiedad)

);

CREATE TABLE Vehiculos (

    idPropiedad INT NOT NULL PRIMARY KEY,
    tipoVehiculo VARCHAR(100),
    capacidad INT,
    almacén INT,
    FOREIGN KEY (idPropiedad) REFERENCES Propiedades(idPropiedad),
    FOREIGN KEY (almacén) REFERENCES Almacenes(idPropiedad)

);

CREATE TABLE Armas (

    idPropiedad INT NOT NULL PRIMARY KEY,
    tipoArmamento VARCHAR(100),
    cantidad INT,
    numBalas INT,
    almacén INT,
    FOREIGN KEY (idPropiedad) REFERENCES Propiedades(idPropiedad),
    FOREIGN KEY (almacén) REFERENCES Almacenes(idPropiedad)

);

# Relaciones entre Acólitos y Contactos

CREATE TABLE Tratos (
    idTrato INT NOT NULL,
    tipoTrato VARCHAR(100),
    contacto VARCHAR(50) NOT NULL,
    acólito VARCHAR(50) NOT NULL,
    PRIMARY KEY (idTrato, contacto, acólito),
    FOREIGN KEY (contacto) REFERENCES Contactos(pseudónimo),
    FOREIGN KEY (acólito) REFERENCES Acólitos(alias)
);

CREATE TABLE SerSoloContacto (
    contacto VARCHAR(50) NOT NULL,
    acólito VARCHAR(50) NOT NULL,
    PRIMARY KEY (contacto, acólito),
    FOREIGN KEY (contacto) REFERENCES Contactos(pseudónimo),
    FOREIGN KEY (acólito) REFERENCES Acólitos(alias)
);

# Relación entre Acólitos y guiaEspiritual

CREATE TABLE Ritos (

    idRito INT NOT NULL,
    tipoRito VARCHAR(100),
    acólito VARCHAR(50) NOT NULL,
    guiaEspiritual VARCHAR(50) NOT NULL,
    fechaHora DATETIME,
    PRIMARY KEY (idRito, guiaEspiritual, acólito),
    FOREIGN KEY (acólito) REFERENCES Acólitos(alias),
    FOREIGN KEY (guiaEspiritual) REFERENCES Guia_espiritual(alias) 

);

# Tablas relacionadas con los eventos que la secta organiza

CREATE TABLE Eventos (

    ubicacion VARCHAR(255) NOT NULL,
    fecha DATE NOT NULL,
    tipoEvento VARCHAR(100),
    descripcion TEXT,
    autorizador VARCHAR(50),
    organizador VARCHAR(50),
    PRIMARY KEY (ubicacion, fecha),
    FOREIGN KEY (autorizador) REFERENCES Cabecillas(alias),
    FOREIGN KEY (organizador) REFERENCES Jefes_de_division(alias)

);

CREATE TABLE Objetivos (

    idObjetivo INT NOT NULL,
    ubicacion VARCHAR(255) NOT NULL,
    fecha DATE NOT NULL,
    descripción TEXT,
    prioridad INT,
    PRIMARY KEY (idObjetivo, Ubicación, fecha),
    FOREIGN KEY (ubicacion, fecha) REFERENCES Eventos(ubicacion, fecha)

);

CREATE TABLE ProporcionarApoyo (

    jefe VARCHAR(50) NOT NULL,
    ubicacion VARCHAR(255) NOT NULL,
    fecha DATE NOT NULL,
    PRIMARY KEY (jefe, ubicacion, fecha),
    FOREIGN KEY (jefe) REFERENCES Jefes_de_división (alias),
    FOREIGN KEY (ubicacion, fecha) REFERENCES Eventos (ubicacion, fecha)

);

CREATE TABLE PropiedadesUsadas (

    idPropiedad INT NOT NULL,
    ubicacion VARCHAR(255) NOT NULL,
    fecha DATE NOT NULL,
    PRIMARY KEY (idPropiedad, ubicacion, fecha),
    FOREIGN KEY (idPropiedad) REFERENCES Propiedades (idPropiedad),
    FOREIGN KEY (ubicacion, fecha) REFERENCES Eventos (ubicacion, fecha)

);

CREATE TABLE Recompensas_Dinero (

    idRecompensa INT NOT NULL PRIMARY KEY,
    dinero DECIMAL(10,2)

);

CREATE TABLE Recompensas_Influencia (

    idRecompensa INT NOT NULL PRIMARY KEY,
    influencia INTEGER

);

CREATE TABLE Recompensas_Contacto (

    idRecompensa INT NOT NULL PRIMARY KEY,
    dinero DECIMAL(10,2),
    contacto VARCHAR(50),
    FOREIGN KEY (contacto) REFERENCES Contactos (pseudónimo)

);




