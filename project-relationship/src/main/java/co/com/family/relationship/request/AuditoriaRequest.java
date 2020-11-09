package co.com.family.relationship.request;

import lombok.Data;

@Data
public class AuditoriaRequest {
  String idAuditoria;
  String nombreTabla;
  String evento;
  String paramEntrada;
  String valueOld;
  String valueNew;
  String respuestaTransac;
}
