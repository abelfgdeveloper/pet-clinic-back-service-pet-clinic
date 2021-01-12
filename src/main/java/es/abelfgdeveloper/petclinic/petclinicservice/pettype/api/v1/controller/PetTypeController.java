package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.controller;

import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.PetTypeApi;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.mapper.PetTypeMapper;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.CreatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.UpdatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypePaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypeResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.validation.CreatePetTypeRequestResourceValidator;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.validation.PetTypePaginatedResponseResourceValidator;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.validation.PetTypeResponseResourceValidator;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.validation.UpdatePetTypeRequestResourceValidator;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.CreatePetTypeUseCase;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.DeletePetTypeByIdUseCase;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.FindAllPetTypePaginatedUseCase;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.FindPetTypeByIdUseCase;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1.UpdatePetTypeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PetTypeController implements PetTypeApi {

  private final CreatePetTypeUseCase createPetTypeUseCase;
  private final UpdatePetTypeUseCase updatePetTypeUseCase;
  private final DeletePetTypeByIdUseCase deletePetTypeByIdUseCase;
  private final FindPetTypeByIdUseCase findPetTypeByIdUseCase;
  private final FindAllPetTypePaginatedUseCase findAllPetTypePaginatedUseCase;

  private final CreatePetTypeRequestResourceValidator createPetTypeRequestResourceValidator;
  private final UpdatePetTypeRequestResourceValidator updatePetTypeRequestResourceValidator;
  private final PetTypeResponseResourceValidator petTypeResponseResourceValidator;
  private final PetTypePaginatedResponseResourceValidator petTypePaginatedResponseResourceValidator;

  private final PetTypeMapper petTypeMapper;

  @Override
  public PetTypeResponseResource create(CreatePetTypeRequestResource request) {
    createPetTypeRequestResourceValidator.validate(request);
    PetTypeResponseResource response =
        petTypeMapper.map(createPetTypeUseCase.execute(petTypeMapper.map(request)));
    petTypeResponseResourceValidator.validate(response);
    return response;
  }

  @Override
  public PetTypeResponseResource update(String id, UpdatePetTypeRequestResource request) {
    updatePetTypeRequestResourceValidator.validate(request);
    PetTypeResponseResource response =
        petTypeMapper.map(updatePetTypeUseCase.execute(id, petTypeMapper.map(request)));
    petTypeResponseResourceValidator.validate(response);
    return response;
  }

  @Override
  public void deleteById(String id) {
    deletePetTypeByIdUseCase.execute(id);
  }

  @Override
  public PetTypeResponseResource findById(String id) {
    PetTypeResponseResource response = petTypeMapper.map(findPetTypeByIdUseCase.execute(id));
    petTypeResponseResourceValidator.validate(response);
    return response;
  }

  @Override
  public PetTypePaginatedResponseResource findAll() {
    PetTypePaginatedResponseResource response =
        petTypeMapper.map(findAllPetTypePaginatedUseCase.execute());
    petTypePaginatedResponseResourceValidator.validate(response);
    return response;
  }
}
