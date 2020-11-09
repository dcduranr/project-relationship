package co.com.family.relationship.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "auditoria", schema = "family")
@Data
public class AuditoriaEntity {
  
  @Id
  @Column(name = "id_autoria", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  int idAuditoria;
  
  @Column(name = "nombre_tabla", nullable = false)
  String nombreTabla;
  
  @Column(name = "evento", nullable = false)
  String evento;
  
  @Column(name = "param_entrada", nullable = false)
  String paramEntrada;
  
  @Column(name = "value_old", nullable = false)
  String valueOld;
  
  @Column(name = "value_new", nullable = false)
  String valueNew;
  
  @Column(name = "fecha_transac", nullable = false)
  Date fechaTransac;
  
  @Column(name = "respuesta_transac", nullable = false)
  String respuestaTransac;

}
