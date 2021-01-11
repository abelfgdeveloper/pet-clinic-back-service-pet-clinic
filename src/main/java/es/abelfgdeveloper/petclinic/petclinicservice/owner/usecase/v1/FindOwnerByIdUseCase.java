package es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1;

import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.Owner;

public interface FindOwnerByIdUseCase {

  Owner execute(String id);
}
