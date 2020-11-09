CREATE TABLE family.persona (
  id_persona varchar(20) NOT NULL,
  nombres varchar(50) NOT NULL,
  apellidos varchar(50) NOT NULL,
  fecha_nac date NOT NULL,
  sexo varchar(1) NOT NULL,
  direccion varchar(250) NOT NULL,
  telefono varchar(20) NOT NULL,
  correo varchar(50) DEFAULT NULL,
  estado_civil varchar(15) DEFAULT NULL,
  PRIMARY KEY (id_persona)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE family.persona_relacion (
  idpersona_relacion INT NOT NULL AUTO_INCREMENT,
  id_persona_ppal VARCHAR(20) NULL,
  id_persona_sec VARCHAR(20) NULL,
  parentesco VARCHAR(20) NOT NULL,
  PRIMARY KEY (idpersona_relacion),
  CONSTRAINT fk_persona_ppal FOREIGN KEY (id_persona_ppal) REFERENCES family.persona (id_persona),
  CONSTRAINT fk_persona_sec FOREIGN KEY (id_persona_sec) REFERENCES family.persona (id_persona)
  ON DELETE CASCADE
  ON UPDATE CASCADE);
  
  CREATE TABLE family.autoria (
  id_autoria INT NOT NULL AUTO_INCREMENT,
  nombre_tabla VARCHAR(20) NOT NULL,
  evento VARCHAR(10) NOT NULL,
  param_entrada VARCHAR(50) NOT NULL,
  value_old VARCHAR(2000) NULL,
  value_new VARCHAR(2000) NULL,
  fecha_transac DATE NULL,
  respuesta_transac Varchar(25),
  PRIMARY KEY (id_autoria));
    
    
    
      
