package es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1;

import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.Owner;

public interface UpdateOwnerUseCase {

  Owner execute(String id, Owner owner);
}
