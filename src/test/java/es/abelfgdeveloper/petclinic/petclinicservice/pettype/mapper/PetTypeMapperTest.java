package es.abelfgdeveloper.petclinic.petclinicservice.pettype.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetTypeObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetType;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.model.entity.PetTypeEntity;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PetTypeMapperTest {

  PetTypeMapper petTypeMapper;

  @BeforeEach
  void setUp() {
    this.petTypeMapper = new PetTypeMapper();
  }

  @Test
  void test_mapEntityToDomain_ok() {
    // given
    PetTypeEntity petTypeEntity = PetTypeObjectMother.getPetTypeEntity();

    // when
    PetType petType = petTypeMapper.map(petTypeEntity);

    // then
    assertEquals(petTypeEntity.getId(), petType.getId());
    assertEquals(petTypeEntity.getName(), petType.getName());
  }

  @Test
  void test_mapEntityListToDomain_ok() {
    // given
    List<PetTypeEntity> petTypesEntity = Arrays.asList(PetTypeObjectMother.getPetTypeEntity());

    // when
    List<PetType> petTypes = petTypeMapper.map(petTypesEntity);

    // then
    assertEquals(1, petTypes.size());
    assertEquals(petTypesEntity.get(0).getId(), petTypes.get(0).getId());
    assertEquals(petTypesEntity.get(0).getName(), petTypes.get(0).getName());
  }

  @Test
  void test_mapEntityListToDomain_emptyList_ok() {
    // given
    List<PetTypeEntity> petTypesEntity = null;

    // when
    List<PetType> petTypes = petTypeMapper.map(petTypesEntity);

    // then
    assertEquals(0, petTypes.size());
  }

  @Test
  void test_mapDomainToEntity_ok() {
    // given
    PetType petType = PetTypeObjectMother.getPetType();

    // when
    PetTypeEntity petTypeEntity = petTypeMapper.map(petType);

    // then
    assertNull(petTypeEntity.getId());
    assertEquals(petType.getName(), petTypeEntity.getName());
  }
}
