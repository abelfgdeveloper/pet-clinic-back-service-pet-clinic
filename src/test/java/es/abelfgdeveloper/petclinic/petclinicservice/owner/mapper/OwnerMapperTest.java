package es.abelfgdeveloper.petclinic.petclinicservice.owner.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.OwnerObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.Owner;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.model.entity.OwnerEntity;
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
  void test_mapDomainToEntity_ok() {
    // given
    Owner owner = OwnerObjectMother.getOwner();

    // when
    OwnerEntity ownerEntity = ownerMapper.map(owner);

    // then
    assertNull(ownerEntity.getId());
    assertEquals(owner.getFirstName(), ownerEntity.getFirstName());
    assertEquals(owner.getLastName(), ownerEntity.getLastName());
    assertEquals(owner.getAddress(), ownerEntity.getAddress());
    assertEquals(owner.getCity(), ownerEntity.getCity());
    assertEquals(owner.getTelephone(), ownerEntity.getTelephone());
  }

  @Test
  void test_mapEntityToDomain_ok() {
    // given
    OwnerEntity ownerEntity = OwnerObjectMother.getOwnerEntity();

    // when
    Owner owner = ownerMapper.map(ownerEntity);

    // then
    assertEquals(ownerEntity.getId(), owner.getId());
    assertEquals(ownerEntity.getFirstName(), owner.getFirstName());
    assertEquals(ownerEntity.getLastName(), owner.getLastName());
    assertEquals(ownerEntity.getAddress(), owner.getAddress());
    assertEquals(ownerEntity.getCity(), owner.getCity());
    assertEquals(ownerEntity.getTelephone(), owner.getTelephone());
  }
}
