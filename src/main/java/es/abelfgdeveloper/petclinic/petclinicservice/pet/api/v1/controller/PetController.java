package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.controller;

import es.abelfgdeveloper.petclinic.petclinicservice.common.mapper.PaginationMapper;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.PetApi;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.mapper.PetMapper;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.CreatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.UpdatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.validation.CreatePetRequestResourceValidator;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.validation.PetPaginatedResponseResourceValidator;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.validation.PetResponseResourceValidator;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.validation.UpdatePetRequestResourceValidator;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1.CreatePetUseCase;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1.DeletePetByIdUseCase;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1.FindPetByIdUseCase;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1.FindPetPaginatedUseCase;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1.UpdatePetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PetController implements PetApi {

  private final CreatePetUseCase createPetUseCase;
  private final UpdatePetUseCase updatePetUseCase;
  private final DeletePetByIdUseCase deletePetByIdUseCase;
  private final FindPetByIdUseCase findPetByIdUseCase;
  private final FindPetPaginatedUseCase findPetPaginatedUseCase;

  private final CreatePetRequestResourceValidator createPetRequestResourceValidator;
  private final UpdatePetRequestResourceValidator updatePetRequestResourceValidator;
  private final PetResponseResourceValidator petResponseResourceValidator;
  private final PetPaginatedResponseResourceValidator petPaginatedResponseResourceValidator;

  private final PetMapper petMapper;
  private final PaginationMapper paginationMapper;

  @Override
  public PetResponseResource create(CreatePetRequestResource request) {
    createPetRequestResourceValidator.validate(request);
    PetResponseResource response = petMapper.map(createPetUseCase.execute(petMapper.map(request)));
    petResponseResourceValidator.validate(response);
    return response;
  }

  @Override
  public PetResponseResource update(String petId, UpdatePetRequestResource request) {
    updatePetRequestResourceValidator.validate(request);
    PetResponseResource response =
        petMapper.map(updatePetUseCase.execute(petId, petMapper.map(request)));
    petResponseResourceValidator.validate(response);
    return response;
  }

  @Override
  public void deleteById(String petId) {
    deletePetByIdUseCase.execute(petId);
  }

  @Override
  public PetResponseResource findById(String petId) {
    PetResponseResource response = petMapper.map(findPetByIdUseCase.execute(petId));
    petResponseResourceValidator.validate(response);
    return response;
  }

  @Override
  public PetPaginatedResponseResource findAll(Integer page, Integer size) {
    paginationMapper.map(page, size);
    PetPaginatedResponseResource response =
        petMapper.map(findPetPaginatedUseCase.execute(paginationMapper.map(page, size)));
    petPaginatedResponseResourceValidator.validate(response);
    return response;
  }
}
