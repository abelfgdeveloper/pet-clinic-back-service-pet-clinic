package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PetPaginatedResponseResource {

  private List<PetResponseResource> pets;
}
