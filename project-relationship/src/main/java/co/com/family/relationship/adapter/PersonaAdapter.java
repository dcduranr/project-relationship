package co.com.family.relationship.adapter;

import org.springframework.stereotype.Component;
import co.com.family.relationship.entities.PersonaEntity;
import co.com.family.relationship.entities.PersonaRelacionEntity;
import co.com.family.relationship.request.PersonaRelationRequest;
import co.com.family.relationship.request.PersonaRequest;
import co.com.family.relationship.response.DatosBasicosResponse;
import co.com.family.relationship.response.FamiliaResponse;
import co.com.family.relationship.response.PersonaResponse;
import co.com.family.relationship.utils.UtilCommons;

@Component
public class PersonaAdapter {
  
  public PersonaEntity getPersonaEntity(PersonaRequest personaRequest) throws Exception {
    PersonaEntity personaEntity= new PersonaEntity();
    personaEntity.setIdPersona(personaRequest.getIdPersona());
    personaEntity.setNombres(personaRequest.getNombres());
    personaEntity.setApellidos(personaRequest.getApellidos());
    personaEntity.setCorreo(personaRequest.getCorreo());
    personaEntity.setDireccion(personaRequest.getDireccion());
    personaEntity.setEstadoCivil(personaRequest.getEstadoCivil());
    personaEntity.setFechaNac(UtilCommons.ParseFecha(personaRequest.getFechaNac()));
    personaEntity.setSexo(personaRequest.getSexo());
    personaEntity.setTelefono(personaRequest.getTelefono());
    return personaEntity;
    
  }

  public PersonaRelacionEntity getPersonaRelacionEntity(PersonaRelationRequest personaRelationRequest) {
    PersonaRelacionEntity personaRelacionEntity= new PersonaRelacionEntity();
    personaRelacionEntity.setIdPersonaPpal(personaRelationRequest.getIdPersonaPpal());
    personaRelacionEntity.setIdPersonaSec(personaRelationRequest.getIdPersonaSec());
    personaRelacionEntity.setParentesco(personaRelationRequest.getParentesco());
    return personaRelacionEntity;
  }
  
  public PersonaResponse getPersonaResponse(PersonaEntity personaEntity) {
    PersonaResponse personaResponse= new PersonaResponse();
    personaResponse.setDatosBasicosResponse(getDatosBasicosResponse(personaEntity));
    return personaResponse;
    
  }
  private DatosBasicosResponse getDatosBasicosResponse(PersonaEntity personaEntity) {
    DatosBasicosResponse datosBasicosResponse= new DatosBasicosResponse();
    datosBasicosResponse.setApellidos(personaEntity.getApellidos());
    datosBasicosResponse.setCorreo(personaEntity.getCorreo());
    datosBasicosResponse.setDireccion(personaEntity.getDireccion());
    datosBasicosResponse.setNombres(personaEntity.getNombres());
    datosBasicosResponse.setEstadoCivil(personaEntity.getEstadoCivil());
    datosBasicosResponse.setSexo(personaEntity.getSexo());
    datosBasicosResponse.setIdPersona(personaEntity.getIdPersona());
    datosBasicosResponse.setTelefono(personaEntity.getTelefono());
    datosBasicosResponse.setFechaNac(personaEntity.getFechaNac().toString());
    return datosBasicosResponse;
    
  }
  
  public FamiliaResponse getPersonaResponse(PersonaEntity personaEntity, String parentesco) {
    FamiliaResponse familiaResponse= new FamiliaResponse();
    familiaResponse.setDatosBasicosResponse(getDatosBasicosResponse(personaEntity));
    familiaResponse.setParentesco(parentesco);  
    return familiaResponse;
    
  }
}
