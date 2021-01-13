package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.mapper;

import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.CreatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.UpdatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.Pet;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.PetPaginated;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component("v1ResourcePetMapper")
public class PetMapper {

  public Pet map(CreatePetRequestResource pet) {
    return Pet.builder()
        .name(pet.getName())
        .birthDate(pet.getBirthDate())
        .petTypeId(pet.getPetTypeId())
        .ownerId(pet.getOwnerId())
        .build();
  }

  public Pet map(UpdatePetRequestResource pet) {
    return Pet.builder().name(pet.getName()).birthDate(pet.getBirthDate()).build();
  }

  public PetResponseResource map(Pet pet) {
    return PetResponseResource.builder()
        .id(pet.getId())
        .name(pet.getName())
        .birthDate(pet.getBirthDate())
        .petTypeId(pet.getPetTypeId())
        .ownerId(pet.getOwnerId())
        .build();
  }

  public PetPaginatedResponseResource map(PetPaginated petPaginated) {
    return PetPaginatedResponseResource.builder()
        .pets(petPaginated.getPets().stream().map(this::map).collect(Collectors.toList()))
        .build();
  }
}
