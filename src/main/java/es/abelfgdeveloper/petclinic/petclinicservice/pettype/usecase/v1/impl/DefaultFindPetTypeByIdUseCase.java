package es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetType;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.service.PetTypeRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.FindPetTypeByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultFindPetTypeByIdUseCase implements FindPetTypeByIdUseCase {

  private final PetTypeRepositoryService petTypeRepositoryService;

  @Transactional(readOnly = true)
  @Override
  public PetType execute(String id) {
    return petTypeRepositoryService.findById(id);
  }
}
