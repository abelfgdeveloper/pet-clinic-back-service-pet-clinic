package es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1;

import es.abelfgdeveloper.petclinic.petclinicservice.common.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.OwnerPaginated;

public interface FindOwnerPaginatedUseCase {

  OwnerPaginated execute(PaginationIn paginationIn);
}
