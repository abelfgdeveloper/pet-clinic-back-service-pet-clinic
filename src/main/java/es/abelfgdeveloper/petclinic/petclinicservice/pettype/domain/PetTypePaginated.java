package es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain;

import es.abelfgdeveloper.petclinic.petclinicservice.common.domain.PaginationOut;
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
public class PetTypePaginated {

  private PaginationOut pagination;
  private List<PetType> petTypes;
}
