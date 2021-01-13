package es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.controller;

import es.abelfgdeveloper.petclinic.petclinicservice.common.mapper.PaginationMapper;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.OwnerApi;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.mapper.OwnerMapper;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.validation.CreateOwnerRequestResourceValidator;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.validation.OwnerPaginatedResponseResourceValidator;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.validation.OwnerResponseResourceValidator;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.validation.UpdateOwnerRequestResourceValidator;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.CreateOwnerUseCase;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.DeleteOwnerByIdUseCase;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.FindOwnerByIdUseCase;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.FindOwnerPaginatedUseCase;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1.UpdateOwnerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OwnerController implements OwnerApi {

  private final CreateOwnerUseCase createOwnerUseCase;
  private final UpdateOwnerUseCase updateOwnerUseCase;
  private final DeleteOwnerByIdUseCase deleteOwnerByIdUseCase;
  private final FindOwnerByIdUseCase findOwnerByIdUseCase;
  private final FindOwnerPaginatedUseCase findOwnerPaginatedUseCase;

  private final CreateOwnerRequestResourceValidator createOwnerRequestResourceValidator;
  private final UpdateOwnerRequestResourceValidator updateOwnerRequestResourceValidator;
  private final OwnerResponseResourceValidator ownerResponseResourceValidator;
  private final OwnerPaginatedResponseResourceValidator ownerPaginatedResponseResourceValidator;

  private final OwnerMapper ownerMapper;
  private final PaginationMapper paginationMapper;

  @Override
  public OwnerResponseResource create(CreateOwnerRequestResource request) {
    createOwnerRequestResourceValidator.validate(request);
    OwnerResponseResource response =
        ownerMapper.map(createOwnerUseCase.execute(ownerMapper.map(request)));
    ownerResponseResourceValidator.validate(response);
    return response;
  }

  @Override
  public OwnerResponseResource update(String ownerId, UpdateOwnerRequestResource request) {
    updateOwnerRequestResourceValidator.validate(request);
    OwnerResponseResource response =
        ownerMapper.map(updateOwnerUseCase.execute(ownerId, ownerMapper.map(request)));
    ownerResponseResourceValidator.validate(response);
    return response;
  }

  @Override
  public void deleteById(String ownerId) {
    deleteOwnerByIdUseCase.execute(ownerId);
  }

  @Override
  public OwnerResponseResource findById(String ownerId) {
    OwnerResponseResource response = ownerMapper.map(findOwnerByIdUseCase.execute(ownerId));
    ownerResponseResourceValidator.validate(response);
    return response;
  }

  @Override
  public OwnerPaginatedResponseResource findAll(Integer page, Integer size) {
    OwnerPaginatedResponseResource response =
        ownerMapper.map(findOwnerPaginatedUseCase.execute(paginationMapper.map(page, size)));
    ownerPaginatedResponseResourceValidator.validate(response);
    return response;
  }
}
