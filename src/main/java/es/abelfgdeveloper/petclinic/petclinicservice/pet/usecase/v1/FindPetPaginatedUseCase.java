package es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1;

import es.abelfgdeveloper.petclinic.petclinicservice.common.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.PetPaginated;

public interface FindPetPaginatedUseCase {

  PetPaginated execute(PaginationIn paginationIn);
}
