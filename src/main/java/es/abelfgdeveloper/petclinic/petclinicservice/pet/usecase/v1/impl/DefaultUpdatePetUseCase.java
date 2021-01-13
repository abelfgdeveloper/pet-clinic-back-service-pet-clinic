package es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.Pet;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.service.PetRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1.UpdatePetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultUpdatePetUseCase implements UpdatePetUseCase {

  private final PetRepositoryService petRepositoryService;

  @Transactional
  @Override
  public Pet execute(String id, Pet pet) {
    return petRepositoryService.update(id, pet);
  }
}
