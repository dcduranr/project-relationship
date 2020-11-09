package co.com.family.relationship.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "persona", schema = "family")
@Data
public class PersonaEntity {
	@Id
	@Column(name = "id_persona", nullable = false)
	String idPersona;
	String nombres;
	String apellidos;
	
	@Column(name = "fecha_nac", nullable = false)
	Date fechaNac;
	String sexo;
	String direccion;
	String telefono;
	String correo;
	
	@Column(name = "estado_civil", nullable = false)
	String estadoCivil;
}
