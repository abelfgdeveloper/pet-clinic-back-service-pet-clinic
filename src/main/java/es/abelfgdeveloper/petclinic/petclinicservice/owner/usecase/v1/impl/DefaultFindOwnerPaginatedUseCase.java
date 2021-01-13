package es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.common.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.OwnerPaginated;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.service.OwnerRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.FindOwnerPaginatedUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultFindOwnerPaginatedUseCase implements FindOwnerPaginatedUseCase {

  private final OwnerRepositoryService ownerRepositoryService;

  @Transactional(readOnly = true)
  @Override
  public OwnerPaginated execute(PaginationIn paginationIn) {
    return ownerRepositoryService.findAll(paginationIn);
  }
}
