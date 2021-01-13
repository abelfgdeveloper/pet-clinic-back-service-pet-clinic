package es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.PetPaginated;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.service.PetRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1.FindAllPetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultFindAllPetUseCase implements FindAllPetUseCase {

  private final PetRepositoryService petRepositoryService;

  @Transactional
  @Override
  public PetPaginated execute() {
    return petRepositoryService.findAll();
  }
}
