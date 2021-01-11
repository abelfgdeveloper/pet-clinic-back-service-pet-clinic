package es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.OwnerObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.util.OwnerErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UpdateOwnerRequestResourceValidatorTest {

  UpdateOwnerRequestResourceValidator updateOwnerRequestResourceValidator;

  @BeforeEach
  void setUp() {
    this.updateOwnerRequestResourceValidator = new UpdateOwnerRequestResourceValidator();
  }

  @Test
  void test_validate_objectNotNull_ko() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource = null;

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(OwnerErrorCode.BODY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_firstNameNotNull_ko() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource =
        OwnerObjectMother.getUpdateOwnerRequestResourceV1();
    updateOwnerRequestResource.setFirstName(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(OwnerErrorCode.FIRST_NAME_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_lastNameNotNull_ko() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource =
        OwnerObjectMother.getUpdateOwnerRequestResourceV1();
    updateOwnerRequestResource.setLastName(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(OwnerErrorCode.LAST_NAME_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_addressNotNull_ko() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource =
        OwnerObjectMother.getUpdateOwnerRequestResourceV1();
    updateOwnerRequestResource.setAddress(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(OwnerErrorCode.ADDRESS_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_cityNotNull_ko() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource =
        OwnerObjectMother.getUpdateOwnerRequestResourceV1();
    updateOwnerRequestResource.setCity(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(OwnerErrorCode.CITY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_telephoneNotNull_ko() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource =
        OwnerObjectMother.getUpdateOwnerRequestResourceV1();
    updateOwnerRequestResource.setTelephone(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationRequestException.class,
            () -> {
              updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);
            });

    // then
    assertEquals(400, exception.getStatus());
    assertEquals(OwnerErrorCode.TELEPHONE_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_ok() {
    // given
    UpdateOwnerRequestResource updateOwnerRequestResource =
        OwnerObjectMother.getUpdateOwnerRequestResourceV1();

    // when
    updateOwnerRequestResourceValidator.validate(updateOwnerRequestResource);

    // then
  }
}
