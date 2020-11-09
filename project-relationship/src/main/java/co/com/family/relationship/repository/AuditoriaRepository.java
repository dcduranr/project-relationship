package co.com.family.relationship.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.com.family.relationship.entities.AuditoriaEntity;

@Repository
public interface AuditoriaRepository
    extends CrudRepository<AuditoriaEntity, Integer> {

}
