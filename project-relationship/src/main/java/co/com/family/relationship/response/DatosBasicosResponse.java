package co.com.family.relationship.response;

import java.sql.Date;

import lombok.Data;

@Data
public class DatosBasicosResponse {
	String idPersona;
	String nombres;
	String apellidos;
	String fechaNac;
	String sexo;
	String direccion;
	String telefono;
	String correo;
	String estadoCivil;

}
