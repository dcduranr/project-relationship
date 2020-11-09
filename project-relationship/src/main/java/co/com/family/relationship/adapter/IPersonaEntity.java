package co.com.family.relationship.adapter;

import java.sql.Date;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import co.com.family.relationship.entities.PersonaEntity;
import co.com.family.relationship.request.PersonaRequest;

@Mapper(componentModel = "spring")
public interface IPersonaEntity {
  @Mapping(target = "idPersona", source = "personaRequest.idPersona")
  @Mapping(target = "nombres", source = "personaRequest.nombres")
  @Mapping(target = "apellidos", source = "personaRequest.apellidos")
  @Mapping(
      source = "personaRequest.fechaNac",
      target = "fechaNac")
  @Mapping(target = "fechaNac", source = "personaRequest.fechaNac")
  @Mapping(target = "sexo", source = "personaRequest.sexo")
  @Mapping(target = "direccion", source = "personaRequest.direccion")
  @Mapping(target = "telefono", source = "personaRequest.telefono")
  @Mapping(target = "correo", source = "personaRequest.correo")
  @Mapping(target = "estadoCivil", source = "personaRequest.estadoCivil")
  
  
  PersonaEntity getPersonaEntity(PersonaRequest personaRequest);
  

  

}
