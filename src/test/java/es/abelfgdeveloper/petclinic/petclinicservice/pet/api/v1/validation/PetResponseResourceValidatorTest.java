package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.server.ValidationResponseException;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.util.PetErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PetResponseResourceValidatorTest {

  PetResponseResourceValidator petResponseResourceValidator;

  @BeforeEach
  void setUp() {
    this.petResponseResourceValidator = new PetResponseResourceValidator();
  }

  @Test
  void test_validate_objectNotNull_ko() {
    // given
    PetResponseResource petResponseResource = null;

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              petResponseResourceValidator.validate(petResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(PetErrorCode.BODY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_idNotNull_ko() {
    // given
    PetResponseResource petResponseResource = PetObjectMother.getPetResponseResourceV1();
    petResponseResource.setId(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              petResponseResourceValidator.validate(petResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(PetErrorCode.ID_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_nameNotNull_ko() {
    // given
    PetResponseResource petResponseResource = PetObjectMother.getPetResponseResourceV1();
    petResponseResource.setName(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              petResponseResourceValidator.validate(petResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(PetErrorCode.NAME_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_birthDateNotNull_ko() {
    // given
    PetResponseResource petResponseResource = PetObjectMother.getPetResponseResourceV1();
    petResponseResource.setBirthDate(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              petResponseResourceValidator.validate(petResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(PetErrorCode.BIRTH_DATE_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_petTypeIdNotNull_ko() {
    // given
    PetResponseResource petResponseResource = PetObjectMother.getPetResponseResourceV1();
    petResponseResource.setPetTypeId(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              petResponseResourceValidator.validate(petResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(PetErrorCode.PET_TYPE_ID_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_ownerIdNotNull_ko() {
    // given
    PetResponseResource petResponseResource = PetObjectMother.getPetResponseResourceV1();
    petResponseResource.setOwnerId(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              petResponseResourceValidator.validate(petResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(PetErrorCode.OWNER_ID_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_ok() {
    // given
    PetResponseResource petResponseResource = PetObjectMother.getPetResponseResourceV1();

    // when
    petResponseResourceValidator.validate(petResponseResource);

    // then
  }
}
