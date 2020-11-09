package co.com.family.relationship.response;

import java.util.List;
import lombok.Data;

@Data
public class PersonaResponse {
	DatosBasicosResponse datosBasicosResponse;
	List<FamiliaResponse> falimiaList;
}
