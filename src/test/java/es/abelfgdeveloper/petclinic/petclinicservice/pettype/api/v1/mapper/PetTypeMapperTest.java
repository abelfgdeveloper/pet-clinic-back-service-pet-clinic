package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import es.abelfgdeveloper.petclinic.petclinicservice.common.mapper.PaginationMapper;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetTypeObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.CreatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.UpdatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypePaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypeResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetType;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetTypePaginated;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PetTypeMapperTest {

  @Mock PaginationMapper paginationMapper;

  PetTypeMapper petTypeMapper;

  @BeforeEach
  void setUp() {
    this.petTypeMapper = new PetTypeMapper(paginationMapper);
  }

  @Test
  void map_createPetTypeRequestResourceToDomain_ok() {
    // given
    CreatePetTypeRequestResource createPetTypeRequestResource =
        PetTypeObjectMother.getCreatePetTypeRequestResourceV1();

    // when
    PetType petType = petTypeMapper.map(createPetTypeRequestResource);

    // then
    assertNull(petType.getId());
    assertEquals(createPetTypeRequestResource.getName(), petType.getName());
  }

  @Test
  void map_updatePetTypeRequestResourceToDomain_ok() {
    // given
    UpdatePetTypeRequestResource updatePetTypeRequestResource =
        PetTypeObjectMother.getUpdatePetTypeRequestResourceV1();

    // when
    PetType petType = petTypeMapper.map(updatePetTypeRequestResource);

    // then
    assertNull(petType.getId());
    assertEquals(updatePetTypeRequestResource.getName(), petType.getName());
  }

  @Test
  void map_DomainToPetTypeResponseResource_ok() {
    // given
    PetType petType = PetTypeObjectMother.getPetType();

    // when
    PetTypeResponseResource petTypeResponseResource = petTypeMapper.map(petType);

    // then
    assertEquals(petType.getId(), petTypeResponseResource.getId());
    assertEquals(petType.getName(), petTypeResponseResource.getName());
  }

  @Test
  void map_DomainToPetTypePaginatedResponseResource_ok() {
    // given
    PetTypePaginated petTypePaginated = PetTypeObjectMother.getPetTypePaginated();

    // when
    PetTypePaginatedResponseResource petTypePaginatedResponseResource =
        petTypeMapper.map(petTypePaginated);

    // then
    assertEquals(1, petTypePaginatedResponseResource.getPetTypes().size());
    assertEquals(
        petTypePaginated.getPetTypes().get(0).getId(),
        petTypePaginatedResponseResource.getPetTypes().get(0).getId());
    assertEquals(
        petTypePaginated.getPetTypes().get(0).getName(),
        petTypePaginatedResponseResource.getPetTypes().get(0).getName());
  }
}
