-- CREACIÓN DE TUPLAS PARA LAS TABLAS

INSERT INTO Acólitos (alias, contraseña, nombreCompleto, fechaIngreso, telefono, direccion, influencia, dinero, primeraEntrada)
VALUES ('mat', 'mateo', 'Mateo Bodenlle', '2024-04-18', 123456789, 'Avenida Villagarcia', 60, 1000.00, true),
       ('saracas', 'sara', 'Sara Castro', '2024-04-21', 987654321, 'Av. Romero Donallo', 5, 50.50, true),
       ('cristo27', 'diego', 'Diego Cristobal', '2024-04-21', 987657321, 'Avenida Villagarcia', 0, 0, true),
       ('minilauri', 'laura', 'Laura Antelo', '2024-04-21', 987654391, 'Rua Joaquin Diaz', 0, 0, true),
       ('iago', 'iago', 'Iago Feijoo', '2024-04-21', 987654721, 'Av. Santa Marta', 0, 0, true),
       ('joselu', 'joselu', 'Jose Luis Estrada', '2024-04-21', 287654321, 'Rua Joaquin Diaz', 0, 0, true),
       ('sebastian', 'sebastian', 'Sebastian', '2024-04-21', 988654321, 'Rua Joaquin Diaz', 0, 0, true);

INSERT INTO Cabecillas (alias)
VALUES ('mat');

INSERT INTO jefes_de_division (alias)
VALUES ('cristo27'), ('joselu'), ('iago');

INSERT INTO miembros_basicos (alias)
VALUES ('minilauri'), ('saracas'), ('sebastian');

INSERT INTO gestor_interno (alias)
VALUES ('iago'), ('cristo27');

INSERT INTO guia_espiritual (alias)
VALUES ('joselu');

INSERT INTO Contactos (pseudonimo, nombre, telefono, descripcion)
VALUES ('Pazos', 'Pablo Pazos', 563845824, 'Buen contacto'),
       ('Guti', 'David Gutierrez', 564845824, null),
       ('Nel', 'David Manuel Raposeiras', 857924168, 'Más alto que Diego'),
       ('Javi', 'Javier Outeiriño', 852924168, null);

------------------------------------------------------------------

INSERT INTO sersolocontacto (contacto, acólito)
VALUES ('Guti', 'minilauri'),
       ('Nel', 'saracas');

INSERT INTO tratos (idTRato, tipotrato, contacto, acólito)
VALUES (1, 'Debes un favor', 'Pazos', 'cristo27'),
       (2, 'Extorsión', 'Javi', 'mat');

INSERT INTO ritos (idRito, tiporito, acólito, guiaespiritual, fechahora)
VALUES (1, 'Inicializacion', 'minilauri', 'joselu', TIMESTAMP '2024-04-28 16:00:00'),
       (2, 'Iluminación', 'mat', 'joselu', TIMESTAMP '2024-04-18 23:00:00');

--------------------------------------------------------------------

INSERT INTO Cuentas (IBAN, cantidad, divisa, gestor)
VALUES ('ES1234567890123456789012', 1500.00, 'Dolar', 'iago'),
       ('ES9876543210987654321098', 2000.50, 'Euro', 'iago'),
       ('ES1111111111111111111111', 3000.75, 'Euro', 'cristo27');

INSERT INTO Propiedades (idPropiedad, valor_actual, gestor)
VALUES (1, 70000.00, 'cristo27'), (2, 120000.00, 'cristo27'),
       (3, 500.50, 'iago'), (4, 30000.50, 'cristo27'),
       (5, 10000.75, 'iago'), (6, 100.00, 'iago'), (7, 120.00, 'iago'),
       (8, 250000.00, 'iago'), (9, 195000.00, 'cristo27');

INSERT INTO Inmobiliario (idPropiedad, ubicacion, tipoInmobiliario)
VALUES (8, 'Calle Principal 123', 'Casa'),
       (9, 'Avenida Central 456', 'Piso Franco'),
       (1, 'Plaza Mayor 789', 'Almacén'),
       (5, 'Campus Sur 965', 'Almacén');

INSERT INTO Almacenes (idPropiedad, capacidad)
VALUES (1, 100), (5, 120);

INSERT INTO Vehiculos (idPropiedad, tipoVehiculo, capacidad, almacén)
values (4, 'Automóvil', 8, 1), (2, 'Camión', 20, 1);

INSERT INTO Armas (idPropiedad, tipoArmamento, cantidad, numBalas, almacén)
VALUES (6, 'Pistola', 10, 100, 5),
       (3, 'Escopeta', 20, 50, 5),
       (7, 'Rifle de asalto', 5, 20, 5);

------------------------------------------------------------------------

INSERT INTO Eventos (ubicacion, fecha, tipoEvento, descripcion, autorizador, organizador)
VALUES ('Parque Central', '2024-05-15', 'Tiro al blanco', null, 'mat', 'iago'),
       ('Centro de Entrenamiento', '2024-06-20', 'Entrenamiento de Autodefensa', 'Se realizarán actividades de dominio de armas', 'mat', 'cristo27'),
       ('Teatro Municipal', '2024-07-10', 'Conferencia sobre religión', null, 'mat', 'joselu');

INSERT INTO propiedadesusadas (idPropiedad, ubicacion, fecha)
VALUES (7, 'Parque Central', '2024-05-15'), (2, 'Parque Central', '2024-05-15'),
       (6, 'Centro de Entrenamiento', '2024-06-20');