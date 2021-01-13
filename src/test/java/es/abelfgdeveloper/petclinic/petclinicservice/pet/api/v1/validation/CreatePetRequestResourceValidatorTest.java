package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.CreatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.util.PetErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreatePetRequestResourceValidatorTest {

  CreatePetRequestResourceValidator createPetRequestResourceValidator;

  @BeforeEach
  void setUp() {
    this.createPetRequestResourceValidator = new CreatePetRequestResourceValidator();
  }

  @Test
  void test_validate_objectNotNull_ko() {
    // given
    CreatePetRequestResource createPetRequestResource = null;

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              createPetRequestResourceValidator.validate(createPetRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(PetErrorCode.BODY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_nameNotNull_ko() {
    // given
    CreatePetRequestResource createPetRequestResource =
        PetObjectMother.getCreatePetRequestResourceV1();
    createPetRequestResource.setName(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              createPetRequestResourceValidator.validate(createPetRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(PetErrorCode.NAME_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_birthDateNotNull_ko() {
    // given
    CreatePetRequestResource createPetRequestResource =
        PetObjectMother.getCreatePetRequestResourceV1();
    createPetRequestResource.setBirthDate(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              createPetRequestResourceValidator.validate(createPetRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(PetErrorCode.BIRTH_DATE_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_petTypeIdNotNull_ko() {
    // given
    CreatePetRequestResource createPetRequestResource =
        PetObjectMother.getCreatePetRequestResourceV1();
    createPetRequestResource.setPetTypeId(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              createPetRequestResourceValidator.validate(createPetRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(PetErrorCode.PET_TYPE_ID_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_ownerIdNotNull_ko() {
    // given
    CreatePetRequestResource createPetRequestResource =
        PetObjectMother.getCreatePetRequestResourceV1();
    createPetRequestResource.setOwnerId(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              createPetRequestResourceValidator.validate(createPetRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(PetErrorCode.OWNER_ID_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_ok() {
    // given
    CreatePetRequestResource createPetRequestResource =
        PetObjectMother.getCreatePetRequestResourceV1();

    // when
    createPetRequestResourceValidator.validate(createPetRequestResource);

    // then
  }
}
