CREATE TABLE genero (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE puestos_trabajo (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE usuario (
  id INT NOT NULL AUTO_INCREMENT,
  nick_usuario VARCHAR(50) NOT NULL UNIQUE,
  contrasena VARCHAR(255) NOT NULL,
  fecha_hora_creacion DATETIME NOT NULL,
  genero_id INT NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  primer_apellido VARCHAR(100) NOT NULL,
  segundo_apellido VARCHAR(100) NULL,
  fecha_nacimiento DATE NOT NULL,
  hora_desayuno TIME NULL,
  puesto_trabajo_id INT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_usuario_genero FOREIGN KEY (genero_id) REFERENCES genero (id),
  CONSTRAINT fk_usuario_puesto FOREIGN KEY (puesto_trabajo_id) REFERENCES puestos_trabajo (id)
) ENGINE=InnoDB;

CREATE TABLE direccion (
  id INT NOT NULL AUTO_INCREMENT,
  nombre_calle VARCHAR(255) NOT NULL,
  numero_calle INT NULL,
  usuario_id INT NOT NULL,
  direccion_principal BOOLEAN NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  CONSTRAINT fk_direccion_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id) ON DELETE CASCADE
) ENGINE=InnoDB;

