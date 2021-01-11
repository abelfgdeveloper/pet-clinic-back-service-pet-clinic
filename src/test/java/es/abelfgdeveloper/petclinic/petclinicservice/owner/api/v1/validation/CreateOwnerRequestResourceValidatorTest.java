package es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.OwnerObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.util.OwnerErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateOwnerRequestResourceValidatorTest {

  CreateOwnerRequestResourceValidator createOwnerRequestResourceValidator;

  @BeforeEach
  void setUp() {
    this.createOwnerRequestResourceValidator = new CreateOwnerRequestResourceValidator();
  }

  @Test
  void test_validate_objectNotNull_ko() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource = null;

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(OwnerErrorCode.BODY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_firstNameNotNull_ko() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource =
        OwnerObjectMother.getCreateOwnerRequestResourceV1();
    createOwnerRequestResource.setFirstName(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(OwnerErrorCode.FIRST_NAME_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_lastNameNotNull_ko() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource =
        OwnerObjectMother.getCreateOwnerRequestResourceV1();
    createOwnerRequestResource.setLastName(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(OwnerErrorCode.LAST_NAME_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_addressNotNull_ko() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource =
        OwnerObjectMother.getCreateOwnerRequestResourceV1();
    createOwnerRequestResource.setAddress(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(OwnerErrorCode.ADDRESS_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_cityNotNull_ko() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource =
        OwnerObjectMother.getCreateOwnerRequestResourceV1();
    createOwnerRequestResource.setCity(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(OwnerErrorCode.CITY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_telephoneNotNull_ko() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource =
        OwnerObjectMother.getCreateOwnerRequestResourceV1();
    createOwnerRequestResource.setTelephone(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              createOwnerRequestResourceValidator.validate(createOwnerRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(OwnerErrorCode.TELEPHONE_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_ok() {
    // given
    CreateOwnerRequestResource createOwnerRequestResource =
        OwnerObjectMother.getCreateOwnerRequestResourceV1();

    // when
    createOwnerRequestResourceValidator.validate(createOwnerRequestResource);

    // then
  }
}
