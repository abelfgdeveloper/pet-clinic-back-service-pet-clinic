package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.server.ValidationResponseException;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetTypeObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypeResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.util.PetTypeErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PetTypeResponseResourceValidatorTest {

  PetTypeResponseResourceValidator petTypeResponseResourceValidator;

  @BeforeEach
  void setUp() {
    this.petTypeResponseResourceValidator = new PetTypeResponseResourceValidator();
  }

  @Test
  void test_validate_objectNotNull_ko() {
    // given
    PetTypeResponseResource petTypeResponseResource = null;

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              petTypeResponseResourceValidator.validate(petTypeResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(PetTypeErrorCode.BODY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_idNotNull_ko() {
    // given
    PetTypeResponseResource petTypeResponseResource =
        PetTypeObjectMother.getPetTypeResponseResourceV1();
    petTypeResponseResource.setId(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              petTypeResponseResourceValidator.validate(petTypeResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(PetTypeErrorCode.ID_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_nameNotNull_ko() {
    // given
    PetTypeResponseResource petTypeResponseResource =
        PetTypeObjectMother.getPetTypeResponseResourceV1();
    petTypeResponseResource.setName(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              petTypeResponseResourceValidator.validate(petTypeResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(PetTypeErrorCode.NAME_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_ok() {
    // given
    PetTypeResponseResource petTypeResponseResource =
        PetTypeObjectMother.getPetTypeResponseResourceV1();

    // when
    petTypeResponseResourceValidator.validate(petTypeResponseResource);

    // then
  }
}
