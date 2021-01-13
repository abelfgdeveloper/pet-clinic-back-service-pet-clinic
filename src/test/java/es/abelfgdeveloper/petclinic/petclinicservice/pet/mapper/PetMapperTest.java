package es.abelfgdeveloper.petclinic.petclinicservice.pet.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.Pet;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.model.entity.PetEntity;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PetMapperTest {

  PetMapper petMapper;

  @BeforeEach
  void setUp() {
    this.petMapper = new PetMapper();
  }

  @Test
  void test_mapEntityToDomain_ok() {
    // given
    PetEntity petEntity = PetObjectMother.getPetEntity();

    // when
    Pet pet = petMapper.map(petEntity);

    // then
    assertEquals(petEntity.getId(), pet.getId());
    assertEquals(petEntity.getName(), pet.getName());
  }

  @Test
  void test_mapEntityListToDomain_ok() {
    // given
    List<PetEntity> petsEntity = Arrays.asList(PetObjectMother.getPetEntity());

    // when
    List<Pet> pets = petMapper.map(petsEntity);

    // then
    assertEquals(1, pets.size());
    assertEquals(petsEntity.get(0).getId(), pets.get(0).getId());
    assertEquals(petsEntity.get(0).getName(), pets.get(0).getName());
  }

  @Test
  void test_mapEntityListToDomain_emptyList_ok() {
    // given
    List<PetEntity> petsEntity = null;

    // when
    List<Pet> pets = petMapper.map(petsEntity);

    // then
    assertEquals(0, pets.size());
  }

  @Test
  void test_mapDomainToEntity_ok() {
    // given
    Pet pet = PetObjectMother.getPet();

    // when
    PetEntity petEntity = petMapper.map(pet);

    // then
    assertNull(petEntity.getId());
    assertEquals(pet.getName(), petEntity.getName());
  }
}
