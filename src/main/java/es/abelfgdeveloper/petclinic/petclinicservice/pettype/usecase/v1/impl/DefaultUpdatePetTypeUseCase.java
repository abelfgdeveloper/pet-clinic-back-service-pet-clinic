package es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetType;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.service.PetTypeRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.UpdatePetTypeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultUpdatePetTypeUseCase implements UpdatePetTypeUseCase {

  private final PetTypeRepositoryService petTypeRepositoryService;

  @Transactional
  @Override
  public PetType execute(String id, PetType petType) {
    return petTypeRepositoryService.update(id, petType);
  }
}
