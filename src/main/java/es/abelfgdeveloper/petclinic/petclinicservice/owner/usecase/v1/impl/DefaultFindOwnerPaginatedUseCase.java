package es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.OwnerPaginated;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.service.OwnerRespositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.FindOwnerPaginatedUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultFindOwnerPaginatedUseCase implements FindOwnerPaginatedUseCase {

  private final OwnerRespositoryService ownerRespositoryService;

  @Transactional(readOnly = true)
  @Override
  public OwnerPaginated execute() {
    return ownerRespositoryService.findAll();
  }
}
