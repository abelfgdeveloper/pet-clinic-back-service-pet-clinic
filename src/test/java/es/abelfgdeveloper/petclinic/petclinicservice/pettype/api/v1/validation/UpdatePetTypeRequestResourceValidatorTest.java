package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetTypeObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.UpdatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.util.PetTypeErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdatePetTypeRequestResourceValidatorTest {

  UpdatePetTypeRequestResourceValidator updatePetTypeRequestResourceValidator;

  @BeforeEach
  void setUp() {
    this.updatePetTypeRequestResourceValidator = new UpdatePetTypeRequestResourceValidator();
  }

  @Test
  void test_validate_objectNotNull_ko() {
    // given
    UpdatePetTypeRequestResource updatePetTypeRequestResource = null;

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              updatePetTypeRequestResourceValidator.validate(updatePetTypeRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(PetTypeErrorCode.BODY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_nameNotNull_ko() {
    // given
    UpdatePetTypeRequestResource updatePetTypeRequestResource =
        PetTypeObjectMother.getUpdatePetTypeRequestResourceV1();
    updatePetTypeRequestResource.setName(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              updatePetTypeRequestResourceValidator.validate(updatePetTypeRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(PetTypeErrorCode.NAME_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_ok() {
    // given
    UpdatePetTypeRequestResource updatePetTypeRequestResource =
        PetTypeObjectMother.getUpdatePetTypeRequestResourceV1();

    // when
    updatePetTypeRequestResourceValidator.validate(updatePetTypeRequestResource);

    // then
  }
}
