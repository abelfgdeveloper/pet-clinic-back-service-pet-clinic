package es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.pet.service.PetRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1.DeletePetByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultDeletePetByIdUseCase implements DeletePetByIdUseCase {

  private final PetRepositoryService petRepositoryService;

  @Transactional
  @Override
  public void execute(String id) {
    petRepositoryService.deleteById(id);
  }
}
