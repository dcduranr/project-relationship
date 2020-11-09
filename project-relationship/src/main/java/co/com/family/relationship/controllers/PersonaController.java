package co.com.family.relationship.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.family.relationship.request.PersonaRelationRequest;
import co.com.family.relationship.request.PersonaRequest;
import co.com.family.relationship.response.PersonaResponse;
import co.com.family.relationship.services.PersonaRelacionService;
import co.com.family.relationship.services.PersonaService;
import static co.com.family.relationship.utils.Constant.*;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaController {

  @Autowired
  private PersonaService personaService;

  @Autowired
  private PersonaRelacionService personaRelacionServiceService;


  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity insertPerson(@RequestBody PersonaRequest personaRequest) throws Exception {
    if (personaService.savePersona(personaRequest,EVENTO_GUARDAR)) {
      return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
    return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
  }
  
  @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity updatePerson(@RequestBody PersonaRequest personaRequest) throws Exception {
    if (personaService.savePersona(personaRequest,EVENTO_ACTUALIZAR)) {
      return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
    return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
  }
  
 
  @DeleteMapping(value = "/{idPersona}")
  public ResponseEntity deletePerson(@PathVariable String idPersona) throws Exception {
    if (personaService.deletePersona(idPersona)) {
      return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
    return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
  }

  @GetMapping(value = "/{idPersona}")
  public ResponseEntity getPerson(@PathVariable String idPersona) throws Exception {
    Optional<PersonaResponse> result=personaService.getPersona(idPersona);
    if (result.isPresent()) {
      return new ResponseEntity<PersonaResponse>(result.get(), HttpStatus.OK);
    }
    return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
  }

  @PostMapping("/relacion")
  public ResponseEntity insertPersonRelation(
      @RequestBody PersonaRelationRequest personaRelationRequest) {
    if (personaRelacionServiceService.savePersonaRelation(personaRelationRequest,EVENTO_GUARDAR)) {
      return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
      return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
    }
  
  @PutMapping("/relacion")
  public ResponseEntity updatePersonRelation(
      @RequestBody PersonaRelationRequest personaRelationRequest) {
    if (personaRelacionServiceService.savePersonaRelation(personaRelationRequest,EVENTO_ACTUALIZAR)) {
      return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
      return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
    }
  
  @DeleteMapping(value = "/relacion/{idPersonaPpal}/{idPersonaSec}")
  public ResponseEntity deletePersonRelation(
      @PathVariable String idPersonaPpal,@PathVariable String idPersonaSec) {
    if (personaRelacionServiceService.deletePersonaRelacion(idPersonaPpal, idPersonaSec)) {
      return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
      return new ResponseEntity<Boolean>(false, HttpStatus.CONFLICT);
    }

}
