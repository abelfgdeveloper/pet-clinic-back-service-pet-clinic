package es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetType;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.service.PetTypeRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.CreatePetTypeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultCreatePetTypeUseCase implements CreatePetTypeUseCase {

  private final PetTypeRepositoryService petTypeRepositoryService;

  @Transactional
  @Override
  public PetType execute(PetType petType) {
    return petTypeRepositoryService.create(petType);
  }
}
