package co.com.family.relationship.adapter;

import java.util.Date;
import org.springframework.stereotype.Component;
import co.com.family.relationship.entities.AuditoriaEntity;
import co.com.family.relationship.request.AuditoriaRequest;

@Component
public class AuditoriaAdapter {
  
  public AuditoriaEntity getAuditoriaEntity(AuditoriaRequest auditoriaRequest) throws Exception {
    AuditoriaEntity auditoriaEntity= new AuditoriaEntity();
    auditoriaEntity.setFechaTransac(new Date());
    auditoriaEntity.setNombreTabla(auditoriaRequest.getNombreTabla());
    auditoriaEntity.setEvento(auditoriaRequest.getEvento());
    auditoriaEntity.setParamEntrada(auditoriaRequest.getParamEntrada());
    auditoriaEntity.setValueNew(auditoriaRequest.getValueNew());
    auditoriaEntity.setValueOld(auditoriaRequest.getValueOld());
    auditoriaEntity.setRespuestaTransac(auditoriaRequest.getRespuestaTransac());
    return auditoriaEntity;
    
  }

 
}
