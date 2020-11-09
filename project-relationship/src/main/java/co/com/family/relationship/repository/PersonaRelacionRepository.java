package co.com.family.relationship.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import co.com.family.relationship.entities.PersonaRelacionEntity;

@Repository
public interface PersonaRelacionRepository
    extends CrudRepository<PersonaRelacionEntity, Integer> {
  
  @Query("SELECT personRelac FROM PersonaRelacionEntity personRelac WHERE personRelac.idPersonaPpal = :idPersonaPpal and personRelac.idPersonaSec = :idPersonaSec") 
  Optional<PersonaRelacionEntity> findByIdPersonaPpalAndSec(@Param("idPersonaPpal") String idPersonaPpal, @Param("idPersonaSec") String idPersonaSec);
  

}
