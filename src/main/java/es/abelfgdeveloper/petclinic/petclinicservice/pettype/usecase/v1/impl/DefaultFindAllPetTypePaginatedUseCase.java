package es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.common.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetTypePaginated;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.service.PetTypeRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.FindAllPetTypePaginatedUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultFindAllPetTypePaginatedUseCase implements FindAllPetTypePaginatedUseCase {

  private final PetTypeRepositoryService petTypeRepositoryService;

  @Transactional(readOnly = true)
  @Override
  public PetTypePaginated execute(PaginationIn paginationIn) {
    return petTypeRepositoryService.findAll(paginationIn);
  }
}
