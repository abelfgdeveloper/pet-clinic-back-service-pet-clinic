package es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1;

import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.PetPaginated;

public interface FindAllPetUseCase {

  PetPaginated execute();
}
