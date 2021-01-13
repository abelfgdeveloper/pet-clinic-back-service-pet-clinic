package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import es.abelfgdeveloper.petclinic.petclinicservice.common.mapper.PaginationMapper;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.CreatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.UpdatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.Pet;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.PetPaginated;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PetMapperTest {

  @Mock PaginationMapper paginationMapper;

  PetMapper petMapper;

  @BeforeEach
  void setUp() {
    this.petMapper = new PetMapper(paginationMapper);
  }

  @Test
  void test_createPetRequestResourceToOwner_ok() {
    // given
    CreatePetRequestResource createPetRequestResource =
        PetObjectMother.getCreatePetRequestResourceV1();

    // when
    Pet pet = petMapper.map(createPetRequestResource);

    // then
    assertNull(pet.getId());
    assertEquals(pet.getName(), createPetRequestResource.getName());
    assertEquals(pet.getBirthDate(), createPetRequestResource.getBirthDate());
    assertEquals(pet.getPetTypeId(), createPetRequestResource.getPetTypeId());
    assertEquals(pet.getOwnerId(), createPetRequestResource.getOwnerId());
  }

  @Test
  void test_updatePetRequestResourceToOwner_ok() {
    // given
    UpdatePetRequestResource updatePetRequestResource =
        PetObjectMother.getUpdatePetRequestResourceV1();

    // when
    Pet pet = petMapper.map(updatePetRequestResource);

    // then
    assertNull(pet.getId());
    assertEquals(pet.getName(), updatePetRequestResource.getName());
    assertEquals(pet.getBirthDate(), updatePetRequestResource.getBirthDate());
    assertNull(pet.getPetTypeId());
    assertNull(pet.getOwnerId());
  }

  @Test
  void test_petToPetResponseResource_ok() {
    // given
    Pet pet = PetObjectMother.getPet();

    // when
    PetResponseResource petResponseResource = petMapper.map(pet);

    // then
    assertEquals(petResponseResource.getId(), pet.getId());
    assertEquals(petResponseResource.getName(), pet.getName());
    assertEquals(petResponseResource.getBirthDate(), pet.getBirthDate());
    assertEquals(petResponseResource.getPetTypeId(), pet.getPetTypeId());
    assertEquals(petResponseResource.getOwnerId(), pet.getOwnerId());
  }

  @Test
  void test_petPaginatedToPetPaginatedResponseResource_ok() {
    // given
    PetPaginated petPaginated = PetObjectMother.getPetPaginated();

    // when
    PetPaginatedResponseResource petPaginatedResponseResource = petMapper.map(petPaginated);

    // then
    assertEquals(1, petPaginatedResponseResource.getPets().size());
    assertEquals(
        petPaginated.getPets().get(0).getId(),
        petPaginatedResponseResource.getPets().get(0).getId());
    assertEquals(
        petPaginated.getPets().get(0).getName(),
        petPaginatedResponseResource.getPets().get(0).getName());
    assertEquals(
        petPaginated.getPets().get(0).getBirthDate(),
        petPaginatedResponseResource.getPets().get(0).getBirthDate());
    assertEquals(
        petPaginated.getPets().get(0).getPetTypeId(),
        petPaginatedResponseResource.getPets().get(0).getPetTypeId());
    assertEquals(
        petPaginated.getPets().get(0).getOwnerId(),
        petPaginatedResponseResource.getPets().get(0).getOwnerId());
  }
}
