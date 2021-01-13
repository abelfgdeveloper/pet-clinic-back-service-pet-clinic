package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.UpdatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.util.PetErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdatePetRequestResourceValidatorTest {

  UpdatePetRequestResourceValidator updatePetRequestResourceValidator;

  @BeforeEach
  void setUp() {
    this.updatePetRequestResourceValidator = new UpdatePetRequestResourceValidator();
  }

  @Test
  void test_validate_objectNotNull_ko() {
    // given
    UpdatePetRequestResource updatePetRequestResource = null;

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              updatePetRequestResourceValidator.validate(updatePetRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(PetErrorCode.BODY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_nameNotNull_ko() {
    // given
    UpdatePetRequestResource updatePetRequestResource =
        PetObjectMother.getUpdatePetRequestResourceV1();
    updatePetRequestResource.setName(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              updatePetRequestResourceValidator.validate(updatePetRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(PetErrorCode.NAME_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_birthDateNotNull_ko() {
    // given
    UpdatePetRequestResource updatePetRequestResource =
        PetObjectMother.getUpdatePetRequestResourceV1();
    updatePetRequestResource.setBirthDate(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              updatePetRequestResourceValidator.validate(updatePetRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(PetErrorCode.BIRTH_DATE_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_ok() {
    // given
    UpdatePetRequestResource updatePetRequestResource =
        PetObjectMother.getUpdatePetRequestResourceV1();

    // when
    updatePetRequestResourceValidator.validate(updatePetRequestResource);

    // then
  }
}
