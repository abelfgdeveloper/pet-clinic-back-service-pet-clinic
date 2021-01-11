package es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.OwnerObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.Owner;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.OwnerPaginated;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerMapperTest {

  OwnerMapper ownerMapper;

  @BeforeEach
  void setUp() {
    this.ownerMapper = new OwnerMapper();
  }

  @Test
  void test_createOwnerRequestResourceToOwner_ok() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource =
        OwnerObjectMother.getCreateOwnerRequestResourceV1();

    // when
    Owner owner = ownerMapper.map(createOwnerRequestResource);

    // then
    assertNull(owner.getId());
    assertEquals(owner.getFirstName(), createOwnerRequestResource.getFirstName());
    assertEquals(owner.getLastName(), createOwnerRequestResource.getLastName());
    assertEquals(owner.getAddress(), createOwnerRequestResource.getAddress());
    assertEquals(owner.getCity(), createOwnerRequestResource.getCity());
    assertEquals(owner.getTelephone(), createOwnerRequestResource.getTelephone());
  }

  @Test
  void test_updateOwnerRequestResourceToOwner_ok() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource =
        OwnerObjectMother.getUpdateOwnerRequestResourceV1();

    // when
    Owner owner = ownerMapper.map(updateOwnerRequestResource);

    // then
    assertNull(owner.getId());
    assertEquals(owner.getFirstName(), updateOwnerRequestResource.getFirstName());
    assertEquals(owner.getLastName(), updateOwnerRequestResource.getLastName());
    assertEquals(owner.getAddress(), updateOwnerRequestResource.getAddress());
    assertEquals(owner.getCity(), updateOwnerRequestResource.getCity());
    assertEquals(owner.getTelephone(), updateOwnerRequestResource.getTelephone());
  }

  @Test
  void test_ownerToOwnerResponseResource_ok() {
    // given
    Owner owner = OwnerObjectMother.getOwner();

    // when
    OwnerResponseResource ownerResponseResource = ownerMapper.map(owner);

    // then
    assertEquals(ownerResponseResource.getId(), owner.getId());
    assertEquals(ownerResponseResource.getFirstName(), owner.getFirstName());
    assertEquals(ownerResponseResource.getLastName(), owner.getLastName());
    assertEquals(ownerResponseResource.getAddress(), owner.getAddress());
    assertEquals(ownerResponseResource.getCity(), owner.getCity());
    assertEquals(ownerResponseResource.getTelephone(), owner.getTelephone());
  }

  @Test
  void test_ownerPaginatedToOwnerPaginatedResponseResource_ok() {
    // given
    OwnerPaginated ownerPaginated = OwnerObjectMother.getOwnerPaginated();

    // when
    OwnerPaginatedResponseResource ownerPaginatedResponseResource = ownerMapper.map(ownerPaginated);

    // then
    assertEquals(1, ownerPaginatedResponseResource.getOwners().size());
    assertEquals(
        ownerPaginated.getOwners().get(0).getId(),
        ownerPaginatedResponseResource.getOwners().get(0).getId());
    assertEquals(
        ownerPaginated.getOwners().get(0).getFirstName(),
        ownerPaginatedResponseResource.getOwners().get(0).getFirstName());
    assertEquals(
        ownerPaginated.getOwners().get(0).getLastName(),
        ownerPaginatedResponseResource.getOwners().get(0).getLastName());
    assertEquals(
        ownerPaginated.getOwners().get(0).getAddress(),
        ownerPaginatedResponseResource.getOwners().get(0).getAddress());
    assertEquals(
        ownerPaginated.getOwners().get(0).getCity(),
        ownerPaginatedResponseResource.getOwners().get(0).getCity());
    assertEquals(
        ownerPaginated.getOwners().get(0).getTelephone(),
        ownerPaginatedResponseResource.getOwners().get(0).getTelephone());
  }
}
