package es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1;

import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetType;

public interface UpdatePetTypeUseCase {

  PetType execute(String id, PetType petType);
}
