package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetTypeObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.CreatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.util.PetTypeErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreatePetTypeRequestResourceValidatorTest {

  CreatePetTypeRequestResourceValidator createPetTypeRequestResourceValidator;

  @BeforeEach
  void setUp() {
    this.createPetTypeRequestResourceValidator = new CreatePetTypeRequestResourceValidator();
  }

  @Test
  void test_validate_objectNotNull_ko() {
    // given
    CreatePetTypeRequestResource createPetTypeRequestResource = null;

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              createPetTypeRequestResourceValidator.validate(createPetTypeRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(PetTypeErrorCode.BODY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_nameNotNull_ko() {
    // given
    CreatePetTypeRequestResource createPetTypeRequestResource =
        PetTypeObjectMother.getCreatePetTypeRequestResourceV1();
    createPetTypeRequestResource.setName(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              createPetTypeRequestResourceValidator.validate(createPetTypeRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(PetTypeErrorCode.NAME_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_ok() {
    // given
    CreatePetTypeRequestResource createPetTypeRequestResource =
        PetTypeObjectMother.getCreatePetTypeRequestResourceV1();

    // when
    createPetTypeRequestResourceValidator.validate(createPetTypeRequestResource);

    // then
  }
}
