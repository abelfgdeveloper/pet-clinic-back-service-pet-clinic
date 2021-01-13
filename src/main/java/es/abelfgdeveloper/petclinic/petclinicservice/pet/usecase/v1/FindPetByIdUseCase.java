package es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1;

import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.Pet;

public interface FindPetByIdUseCase {

  Pet execute(String id);
}
