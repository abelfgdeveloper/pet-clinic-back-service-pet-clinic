package es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1;

import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetType;

public interface FindPetTypeByIdUseCase {

  PetType execute(String id);
}
