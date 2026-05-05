INSERT INTO genero (nombre) VALUES ('Masculino'), ('Femenino');
INSERT INTO puestos_trabajo (nombre) VALUES ('Desarrollador Java'), ('Analista IT');
INSERT INTO usuario (nick_usuario, contrasena, fecha_hora_creacion, genero_id, nombre, primer_apellido, fecha_nacimiento, es_admin) 
VALUES ('admin', 'admin123', NOW(), 1, 'Admin', 'Sistema', '1990-01-01', 1);