package co.com.family.relationship.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "persona_relacion", schema = "family")
@Data
public class PersonaRelacionEntity {
  @Id
  @Column(name = "idpersona_relacion", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  int idPersonaRelacion;
  
  @Column(name = "id_persona_ppal", nullable = false)
  String idPersonaPpal;
  
  @Column(name = "id_persona_sec", nullable = false)
  String idPersonaSec;
  
  @Column(name = "parentesco", nullable = false)
  String parentesco;
  
}
