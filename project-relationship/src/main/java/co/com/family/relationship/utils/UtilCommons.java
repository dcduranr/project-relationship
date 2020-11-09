package co.com.family.relationship.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import co.com.family.relationship.request.AuditoriaRequest;

public class UtilCommons {
  static final String FORMAT_DATE="dd/MM/yyyy";
  
  public static Date ParseFecha(String fecha) throws Exception {
    SimpleDateFormat formato = new SimpleDateFormat(FORMAT_DATE);
    Date fechaDate = null;
    try {
      fechaDate = formato.parse(fecha);
    } catch (Exception ex) {
      //Loggear aqui el error
      throw ex;
    }
    return fechaDate;
  }

  public static AuditoriaRequest createAuditoriaRequest(String evento,String nombreTabla, String paramEntrada, String valueNew,String valueOld,String resp) {
    AuditoriaRequest auditoriaRequest= new AuditoriaRequest();
    auditoriaRequest.setEvento(evento);
    auditoriaRequest.setNombreTabla(nombreTabla);
    auditoriaRequest.setParamEntrada(paramEntrada);
    auditoriaRequest.setValueNew(valueNew);
    auditoriaRequest.setValueOld(valueOld);
    auditoriaRequest.setRespuestaTransac(resp);
    return auditoriaRequest;
  }

}
