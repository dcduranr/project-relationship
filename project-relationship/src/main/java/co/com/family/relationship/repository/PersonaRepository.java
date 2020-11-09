package co.com.family.relationship.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import co.com.family.relationship.entities.PersonaEntity;

@Repository
public interface PersonaRepository extends CrudRepository<PersonaEntity, Integer> {

  @Query("SELECT person FROM PersonaEntity person WHERE person.idPersona = :idPersona")
  Optional<PersonaEntity> findByIdPersona(@Param("idPersona") String idPersona);
  
  @Query("SELECT person , personRelac.parentesco FROM PersonaEntity person INNER JOIN  PersonaRelacionEntity personRelac ON person.idPersona=personRelac.idPersonaSec WHERE personRelac.idPersonaPpal = :idPersona")
  Object[] findFamilyByIdPersona(@Param("idPersona") String idPersona);

}
