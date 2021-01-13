package es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.owner.service.OwnerRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.DeleteOwnerByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultDeleteOwnerByIdUseCase implements DeleteOwnerByIdUseCase {

  private final OwnerRepositoryService ownerRepositoryService;

  @Transactional
  @Override
  public void execute(String id) {
    ownerRepositoryService.deleteById(id);
  }
}
