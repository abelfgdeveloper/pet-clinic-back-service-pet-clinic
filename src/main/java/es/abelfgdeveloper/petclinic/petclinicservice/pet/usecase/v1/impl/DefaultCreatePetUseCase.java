package es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.owner.service.OwnerRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.Pet;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.service.PetRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1.CreatePetUseCase;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.service.PetTypeRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultCreatePetUseCase implements CreatePetUseCase {

  private final PetRepositoryService petRepositoryService;
  private final OwnerRepositoryService ownerRepositoryService;
  private final PetTypeRepositoryService petTypeRepositoryService;

  @Transactional
  @Override
  public Pet execute(Pet pet) {
    ownerRepositoryService.findById(pet.getOwnerId());
    petTypeRepositoryService.findById(pet.getPetTypeId());
    return petRepositoryService.create(pet);
  }
}
