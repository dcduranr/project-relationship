package co.com.family.relationship.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import co.com.family.relationship.adapter.AuditoriaAdapter;
import co.com.family.relationship.repository.AuditoriaRepository;
import co.com.family.relationship.request.AuditoriaRequest;

@Service
public class AuditoriaService {
  @Autowired
  AuditoriaRepository auditoriaRepository;
  
  @Autowired
  AuditoriaAdapter auditoriaAdapter;
  
  /**
   * saveAuditoria Metodo usado para guardar las trazas de auditoria
   * @param auditoriaRequest
   * @return retorna un boleano si pudo o no realizar la operacion
   */
  @Async
  public Boolean saveAuditoria(AuditoriaRequest auditoriaRequest) {
    try {
      auditoriaRepository.save(auditoriaAdapter.getAuditoriaEntity(auditoriaRequest));
    } catch (Exception e) {
      return false;
    }
    return true;
  }

}
