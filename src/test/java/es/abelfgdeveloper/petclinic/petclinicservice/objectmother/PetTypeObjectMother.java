package es.abelfgdeveloper.petclinic.petclinicservice.objectmother;

import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.CreatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.UpdatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypePaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypeResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetType;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetTypePaginated;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.model.entity.PetTypeEntity;
import java.util.Arrays;

public class PetTypeObjectMother {

  private PetTypeObjectMother() {}

  public static PetTypeEntity getPetTypeEntity() {
    return PetTypeEntity.builder().id("id1").name("name1").build();
  }

  public static PetType getPetType() {
    return PetType.builder().id("id2").name("name2").build();
  }

  public static PetTypePaginated getPetTypePaginated() {
    return PetTypePaginated.builder().petTypes(Arrays.asList(getPetType())).build();
  }

  public static CreatePetTypeRequestResource getCreatePetTypeRequestResourceV1() {
    return CreatePetTypeRequestResource.builder().name("name3").build();
  }

  public static UpdatePetTypeRequestResource getUpdatePetTypeRequestResourceV1() {
    return UpdatePetTypeRequestResource.builder().name("name4").build();
  }

  public static PetTypeResponseResource getPetTypeResponseResourceV1() {
    return PetTypeResponseResource.builder().id("id5").name("name5").build();
  }

  public static PetTypePaginatedResponseResource getPetTypePaginatedResponseResourceV1() {
    return PetTypePaginatedResponseResource.builder()
        .petTypes(Arrays.asList(getPetTypeResponseResourceV1()))
        .build();
  }
}
