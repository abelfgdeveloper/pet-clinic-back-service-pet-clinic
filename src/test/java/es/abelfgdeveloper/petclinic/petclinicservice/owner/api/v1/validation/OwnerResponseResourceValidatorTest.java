package es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.server.ValidationResponseException;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.OwnerObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.util.OwnerErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerResponseResourceValidatorTest {

  OwnerResponseResourceValidator ownerResponseResourceValidator;

  @BeforeEach
  void setUp() {
    this.ownerResponseResourceValidator = new OwnerResponseResourceValidator();
  }

  @Test
  void test_validate_objectNotNull_ko() {
    // given
    OwnerResponseResource ownerResponseResource = null;

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(OwnerErrorCode.BODY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_idNotNull_ko() {
    // given
    OwnerResponseResource ownerResponseResource = OwnerObjectMother.getOwnerResponseResourceV1();
    ownerResponseResource.setId(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(OwnerErrorCode.ID_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_firstNameNotNull_ko() {
    // given
    OwnerResponseResource ownerResponseResource = OwnerObjectMother.getOwnerResponseResourceV1();
    ownerResponseResource.setFirstName(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(OwnerErrorCode.FIRST_NAME_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_lastNameNotNull_ko() {
    // given
    OwnerResponseResource ownerResponseResource = OwnerObjectMother.getOwnerResponseResourceV1();
    ownerResponseResource.setLastName(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(OwnerErrorCode.LAST_NAME_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_addressNotNull_ko() {
    // given
    OwnerResponseResource ownerResponseResource = OwnerObjectMother.getOwnerResponseResourceV1();
    ownerResponseResource.setAddress(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(OwnerErrorCode.ADDRESS_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_cityNotNull_ko() {
    // given
    OwnerResponseResource ownerResponseResource = OwnerObjectMother.getOwnerResponseResourceV1();
    ownerResponseResource.setCity(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(OwnerErrorCode.CITY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_telephoneNotNull_ko() {
    // given
    OwnerResponseResource ownerResponseResource = OwnerObjectMother.getOwnerResponseResourceV1();
    ownerResponseResource.setTelephone(null);

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              ownerResponseResourceValidator.validate(ownerResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(OwnerErrorCode.TELEPHONE_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_ok() {
    // given
    OwnerResponseResource ownerResponseResource = OwnerObjectMother.getOwnerResponseResourceV1();

    // when
    ownerResponseResourceValidator.validate(ownerResponseResource);

    // then
  }
}
