package co.com.family.relationship.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import co.com.family.relationship.adapter.PersonaAdapter;
import co.com.family.relationship.entities.PersonaEntity;
import co.com.family.relationship.repository.PersonaRepository;
import co.com.family.relationship.request.PersonaRequest;
import co.com.family.relationship.response.FamiliaResponse;
import co.com.family.relationship.response.PersonaResponse;
import static co.com.family.relationship.utils.Constant.*;
import co.com.family.relationship.utils.UtilCommons;

@Service
public class PersonaService {
  @Autowired
  PersonaRepository personaRepository;

  @Autowired
  AuditoriaService auditoriaService;

  @Autowired
  PersonaAdapter personaAdapter;

  public static String TABLA = "Persona";
  
/**
 * savePersona : Método Utilizado  para guardar una Persona
 * @param personaRequest
 * @param metodo
 * @return un booleano si fue posible ejecutar o  no la operacion
 */
  public Boolean savePersona(PersonaRequest personaRequest, String metodo) {
    Gson gson = new Gson();
    String jsonPersonaRequest = gson.toJson(personaRequest);
    String valueOld = "";
    try {
      Optional<PersonaEntity> personaEntity =
          personaRepository.findByIdPersona(personaRequest.getIdPersona());
      valueOld = personaEntity.isPresent() ? gson.toJson(personaEntity) : "";
      personaRepository.save(personaAdapter.getPersonaEntity(personaRequest));
    } catch (Exception e) {
      auditoriaService.saveAuditoria(UtilCommons.createAuditoriaRequest(metodo, TABLA,
          "PersonaRequest", jsonPersonaRequest, valueOld, RESP_FALLO));
      return false;
    }
    auditoriaService.saveAuditoria(UtilCommons.createAuditoriaRequest(metodo, TABLA,
        "PersonaRequest", jsonPersonaRequest, valueOld, RESP_EXITO));
    return true;
  }
  
/**
 * deletePersona :Método usado para eliminar una persona
 * @param idPersona
 * @return un booleano si fue posible ejecutar o  no la operacion
 */
  public Boolean deletePersona(String idPersona) {
    Gson gson = new Gson();
    //Variable para almanecar el registro antes de eliminarlo y guardar en tabla auditoria
    String valueOld = "";
    try {
      //Se consulta primero el registro para almacenar sus valores
      Optional<PersonaEntity> personaEntity = personaRepository.findByIdPersona(idPersona);
      valueOld = personaEntity.isPresent() ? gson.toJson(personaEntity) : "";
      personaRepository.delete(personaEntity.get());
    } catch (Exception e) {
      auditoriaService.saveAuditoria(UtilCommons.createAuditoriaRequest(EVENTO_ELIMINAR, TABLA,
          idPersona, "", valueOld, RESP_FALLO));
      return false;
    }
    auditoriaService.saveAuditoria(UtilCommons.createAuditoriaRequest(EVENTO_ELIMINAR, TABLA,
        idPersona, "", valueOld, RESP_EXITO));
    return true;
  }

  /**
   * getPersona : Metodo que devuelve la persona consulta y la familia de la misma con sus datos
   * @param idPersona
   * @return
   */
  public Optional<PersonaResponse> getPersona(String idPersona) {
    PersonaResponse personaResponse = new PersonaResponse();
    try {
      Optional<PersonaEntity> personaEntity = personaRepository.findByIdPersona(idPersona);
      personaResponse = personaAdapter.getPersonaResponse(personaEntity.get());
      //Se obtiene la familia de la perosona consultada
      Object[] familyList = personaRepository.findFamilyByIdPersona(idPersona);
      List<FamiliaResponse> listFamily = new ArrayList<FamiliaResponse>();
      //Se recorre cada objeto para formar el response a devolver
      for (Object familyObj : familyList) {
        Object[] personEntityList = (Object[]) familyObj;
        PersonaEntity personEntity = (PersonaEntity) personEntityList[0];
        String parentesco = (String) personEntityList[1];
        listFamily.add(personaAdapter.getPersonaResponse(personEntity, parentesco));
      }

      if (!listFamily.isEmpty())
        personaResponse.setFalimiaList(listFamily);
    } catch (Exception e) {
      System.out.println("Error" + e);
    }
    return Optional.of(personaResponse);

  }



}
