package es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.Owner;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.service.OwnerRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.UpdateOwnerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultUpdateOwnerUseCase implements UpdateOwnerUseCase {

  private final OwnerRepositoryService ownerRepositoryService;

  @Transactional
  @Override
  public Owner execute(String id, Owner owner) {
    return ownerRepositoryService.update(id, owner);
  }
}
