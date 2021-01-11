package es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.Owner;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.service.OwnerRespositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.FindOwnerByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DefaultFindOwnerByIdUseCase implements FindOwnerByIdUseCase {

  private final OwnerRespositoryService ownerRespositoryService;

  @Transactional(readOnly = true)
  @Override
  public Owner execute(String id) {
    return ownerRespositoryService.findById(id);
  }
}
