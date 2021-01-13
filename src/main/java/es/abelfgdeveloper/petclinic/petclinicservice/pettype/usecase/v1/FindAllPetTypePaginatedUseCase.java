package es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1;

import es.abelfgdeveloper.petclinic.petclinicservice.common.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetTypePaginated;

public interface FindAllPetTypePaginatedUseCase {

  PetTypePaginated execute(PaginationIn paginationIn);
}
