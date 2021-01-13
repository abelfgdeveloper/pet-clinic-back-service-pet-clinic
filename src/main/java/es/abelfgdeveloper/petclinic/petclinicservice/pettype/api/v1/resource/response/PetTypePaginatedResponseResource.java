package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response;

import es.abelfgdeveloper.petclinic.petclinicservice.common.api.v1.resource.response.PaginationResponseResource;
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
public class PetTypePaginatedResponseResource {

  private PaginationResponseResource pagination;
  private List<PetTypeResponseResource> petTypes;
}
