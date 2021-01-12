package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.server.ValidationResponseException;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetTypeObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypePaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypeResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.util.PetTypeErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PetTypePaginatedResponseResourceValidatorTest {

  @Mock PetTypeResponseResourceValidator petTypeResponseResourceValidator;

  PetTypePaginatedResponseResourceValidator petTypePaginatedResponseResourceValidator;

  @BeforeEach
  void setUp() {
    this.petTypePaginatedResponseResourceValidator =
        new PetTypePaginatedResponseResourceValidator(petTypeResponseResourceValidator);
  }

  @Test
  void test_validate_objectNotNull_ko() {
    // given
    PetTypePaginatedResponseResource petTypePaginatedResponseResource = null;

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              petTypePaginatedResponseResourceValidator.validate(petTypePaginatedResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(PetTypeErrorCode.BODY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate_ok() {
    // given
    PetTypePaginatedResponseResource petTypePaginatedResponseResource =
        PetTypeObjectMother.getPetTypePaginatedResponseResourceV1();

    Mockito.doNothing()
        .when(petTypeResponseResourceValidator)
        .validate(Mockito.any(PetTypeResponseResource.class));

    // when
    petTypePaginatedResponseResourceValidator.validate(petTypePaginatedResponseResource);

    // then
  }
}
