package es.abelfgdeveloper.petclinic.petclinicservice.objectmother;

import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.CreatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.UpdatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.Pet;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.PetPaginated;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.model.entity.PetEntity;
import java.time.LocalDate;
import java.util.Arrays;

public class PetObjectMother {

  private PetObjectMother() {}

  public static PetEntity getPetEntity() {
    return PetEntity.builder()
        .id("id1")
        .name("name2")
        .birthDate(LocalDate.of(2021, 01, 01))
        .petTypeId("petTypeId1")
        .ownerId("ownerId1")
        .build();
  }

  public static Pet getPet() {
    return Pet.builder()
        .id("id2")
        .name("name2")
        .birthDate(LocalDate.of(2021, 01, 02))
        .petTypeId("petTypeId2")
        .ownerId("ownerId2")
        .build();
  }

  public static PetPaginated getPetPaginated() {
    return PetPaginated.builder().pets(Arrays.asList(getPet())).build();
  }

  public static CreatePetRequestResource getCreatePetRequestResourceV1() {
    return CreatePetRequestResource.builder()
        .name("name3")
        .birthDate(LocalDate.of(2021, 01, 03))
        .petTypeId("petTypeId3")
        .ownerId("ownerId3")
        .build();
  }

  public static UpdatePetRequestResource getUpdatePetRequestResourceV1() {
    return UpdatePetRequestResource.builder()
        .name("name4")
        .birthDate(LocalDate.of(2021, 01, 04))
        .build();
  }

  public static PetResponseResource getPetResponseResourceV1() {
    return PetResponseResource.builder()
        .id("id5")
        .name("name5")
        .birthDate(LocalDate.of(2021, 01, 05))
        .petTypeId("petTypeId5")
        .ownerId("ownerId5")
        .build();
  }

  public static PetPaginatedResponseResource getPetPaginatedResponseResourceV1() {
    return PetPaginatedResponseResource.builder()
        .pets(Arrays.asList(getPetResponseResourceV1()))
        .build();
  }
}
