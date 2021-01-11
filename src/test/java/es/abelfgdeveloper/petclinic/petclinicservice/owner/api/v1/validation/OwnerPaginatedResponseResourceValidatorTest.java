package es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.server.ValidationResponseException;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.OwnerObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.util.OwnerErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerPaginatedResponseResourceValidatorTest {

  @Mock OwnerResponseResourceValidator ownerResponseResourceValidator;

  OwnerPaginatedResponseResourceValidator ownerPaginatedResponseResourceValidator;

  @BeforeEach
  void setUp() {
    this.ownerPaginatedResponseResourceValidator =
        new OwnerPaginatedResponseResourceValidator(ownerResponseResourceValidator);
  }

  @Test
  void test_validate_objectNotNull_ko() {
    // given
    OwnerPaginatedResponseResource ownerPaginatedResponseResource = null;

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              ownerPaginatedResponseResourceValidator.validate(ownerPaginatedResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(OwnerErrorCode.BODY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_ok() {
    // given
    OwnerPaginatedResponseResource ownerPaginatedResponseResource =
        OwnerObjectMother.getOwnerPaginatedResponseResourceV1();

    Mockito.doNothing()
        .when(ownerResponseResourceValidator)
        .validate(Mockito.any(OwnerResponseResource.class));

    // when
    ownerPaginatedResponseResourceValidator.validate(ownerPaginatedResponseResource);

    // then
  }
}
