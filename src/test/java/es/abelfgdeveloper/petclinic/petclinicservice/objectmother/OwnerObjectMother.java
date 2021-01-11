package es.abelfgdeveloper.petclinic.petclinicservice.objectmother;

import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.Owner;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.OwnerPaginated;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.model.entity.OwnerEntity;
import java.util.Arrays;

public class OwnerObjectMother {

  private OwnerObjectMother() {}

  public static Owner getOwner() {
    return Owner.builder()
        .id("id1")
        .firstName("firstName1")
        .lastName("lastName1")
        .address("address1")
        .city("city1")
        .telephone("123456789")
        .build();
  }

  public static OwnerEntity getOwnerEntity() {
    return OwnerEntity.builder()
        .id("id2")
        .firstName("firstName2")
        .lastName("lastName2")
        .address("address2")
        .city("city2")
        .telephone("234567891")
        .build();
  }

  public static CreateOwnerRequestResource getCreateOwnerRequestResourceV1() {
    return CreateOwnerRequestResource.builder()
        .firstName("firstName3")
        .lastName("lastName3")
        .address("address3")
        .city("city3")
        .telephone("345678912")
        .build();
  }

  public static UpdateOwnerRequestResource getUpdateOwnerRequestResourceV1() {
    return UpdateOwnerRequestResource.builder()
        .firstName("firstName4")
        .lastName("lastName4")
        .address("address4")
        .city("city4")
        .telephone("456789123")
        .build();
  }

  public static OwnerResponseResource getOwnerResponseResourceV1() {
    return OwnerResponseResource.builder()
        .id("id5")
        .firstName("firstName5")
        .lastName("lastName5")
        .address("address5")
        .city("city5")
        .telephone("567891234")
        .build();
  }

  public static OwnerPaginatedResponseResource getOwnerPaginatedResponseResourceV1() {
    return OwnerPaginatedResponseResource.builder()
        .owners(Arrays.asList(getOwnerResponseResourceV1()))
        .build();
  }

  public static OwnerPaginated getOwnerPaginated() {
    return OwnerPaginated.builder().owners(Arrays.asList(getOwner())).build();
  }
}
