package es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.pettype.service.PetTypeRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.DeletePetTypeByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultDeletePetTypeByIdUseCase implements DeletePetTypeByIdUseCase {

  private final PetTypeRepositoryService petTypeRepositoryService;

  @Transactional
  @Override
  public void execute(String id) {
    petTypeRepositoryService.deleteById(id);
  }
}
