USE `practica_final_backend`;

INSERT INTO genero (nombre) VALUES ('Masculino'), ('Femenino');

INSERT INTO puesto_de_trabajo (nombre) VALUES 
('Desarrollador Java'), 
('Analista IT'), 
('Project Manager'), 
('Soporte Técnico');

INSERT INTO usuario (nick_usuario, contrasena, fecha_hora_creacion, genero_id, nombre, primer_apellido, segundo_apellido, fecha_nacimiento, hora_desayuno, puesto_trabajo_id) 
VALUES ('joselico', '123456', NOW(), 1, 'Jose', 'Ruiz', 'Garcia', '1995-04-29', '08:30:00', 1);

INSERT INTO direccion (nombre_calle, numero_calle, usuario_id, direccion_principal) 
VALUES ('Calle Alta', 17 , 1, 1);