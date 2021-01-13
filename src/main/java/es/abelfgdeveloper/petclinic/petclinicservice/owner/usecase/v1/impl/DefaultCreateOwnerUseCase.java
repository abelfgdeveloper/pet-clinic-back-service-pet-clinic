package es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.Owner;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.service.OwnerRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.CreateOwnerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultCreateOwnerUseCase implements CreateOwnerUseCase {

  private final OwnerRepositoryService ownerRepositoryService;

  @Transactional
  @Override
  public Owner execute(Owner owner) {
    return ownerRepositoryService.create(owner);
  }
}
