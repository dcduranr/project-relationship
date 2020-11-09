package co.com.family.relationship.services;

import static co.com.family.relationship.utils.Constant.EVENTO_ELIMINAR;
import static co.com.family.relationship.utils.Constant.RESP_EXITO;
import static co.com.family.relationship.utils.Constant.RESP_FALLO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import co.com.family.relationship.adapter.PersonaAdapter;
import co.com.family.relationship.entities.PersonaRelacionEntity;
import co.com.family.relationship.repository.PersonaRelacionRepository;
import co.com.family.relationship.request.PersonaRelationRequest;
import co.com.family.relationship.utils.UtilCommons;

@Service
public class PersonaRelacionService {
  @Autowired
  PersonaRelacionRepository personaRelacionRepository;

  @Autowired
  PersonaAdapter personaAdapter;

  @Autowired
  AuditoriaService auditoriaService;

  public static String TABLA = "PersonaRelacion";
  
  
/**
 * savePersonaRelation Metodo usado para guardra la relacion de familiares de una persona
 * @param personaRelationRequest
 * @param metodo indica si será un operacion de guardar o actualizar
 * @return un boleano que indica si pudo o no realizar la operacion
 */
  public Boolean savePersonaRelation(PersonaRelationRequest personaRelationRequest, String metodo) {
    Gson gson = new Gson();
    String jsonPersonaRelationRequest = gson.toJson(personaRelationRequest);
    String valueOld = "";
    try {
      Optional<PersonaRelacionEntity> personaRelacionEntity =
          personaRelacionRepository.findByIdPersonaPpalAndSec(
              personaRelationRequest.getIdPersonaPpal(), personaRelationRequest.getIdPersonaSec());
      valueOld = personaRelacionEntity.isPresent() ? gson.toJson(personaRelacionEntity) : "";
      personaRelacionRepository
          .save(personaAdapter.getPersonaRelacionEntity(personaRelationRequest));
    } catch (Exception e) {
      auditoriaService.saveAuditoria(UtilCommons.createAuditoriaRequest(metodo, TABLA,
          "personaRelationRequest", jsonPersonaRelationRequest, valueOld, RESP_FALLO));
      return false;
    }
    auditoriaService.saveAuditoria(UtilCommons.createAuditoriaRequest(metodo, TABLA,
        "personaRelationRequest", jsonPersonaRelationRequest, valueOld, RESP_EXITO));
    return true;
  }
  
 /**
  * deletePersonaRelacion metodo para eliminar la relacion familiar de una persona
  * @param idPersonaPpal id de la persona del ppal del nucleo familiar
  * @param idPersonaSec id del familiar de la persona ppal
  * @return un boleano si pudo o no realizar la operacion
  */
  public Boolean deletePersonaRelacion(String idPersonaPpal,String idPersonaSec) {
    Gson gson = new Gson();
    String valueOld = "";
    try {
      Optional<PersonaRelacionEntity> personaRelacionEntity =
          personaRelacionRepository.findByIdPersonaPpalAndSec(
              idPersonaPpal, idPersonaSec);
      valueOld = personaRelacionEntity.isPresent() ? gson.toJson(personaRelacionEntity) : "";
      personaRelacionRepository.delete(personaRelacionEntity.get());
    } catch (Exception e) {
      auditoriaService.saveAuditoria(UtilCommons.createAuditoriaRequest(EVENTO_ELIMINAR, TABLA,
          idPersonaPpal + ","+idPersonaSec, "", valueOld, RESP_FALLO));
      return false;
    }
    auditoriaService.saveAuditoria(UtilCommons.createAuditoriaRequest(EVENTO_ELIMINAR, TABLA,
        idPersonaPpal + ","+idPersonaSec,"", valueOld, RESP_EXITO));
    return true;
  }


}
