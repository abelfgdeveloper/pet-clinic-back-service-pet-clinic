package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.server.ValidationResponseException;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.util.PetErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PetPaginatedResponseResourceValidatorTest {

  PetPaginatedResponseResourceValidator petPaginatedResponseResourceValidator;

  @Mock PetResponseResourceValidator petResponseResourceValidator;

  @BeforeEach
  void setUp() {
    this.petPaginatedResponseResourceValidator =
        new PetPaginatedResponseResourceValidator(petResponseResourceValidator);
  }

  @Test
  void test_validate_objectNotNull_ko() {
    // given
    PetPaginatedResponseResource petPaginatedResponseResource = null;

    // when
    AbelfgDeveloperException exception =
        assertThrows(
            ValidationResponseException.class,
            () -> {
              petPaginatedResponseResourceValidator.validate(petPaginatedResponseResource);
            });

    // then
    assertEquals(500, exception.getStatus());
    assertEquals(PetErrorCode.BODY_IS_MANDATORY, exception.getMessage());
  }

  @Test
  void test_validate__ok() {
    // given
    PetPaginatedResponseResource petPaginatedResponseResource =
        PetObjectMother.getPetPaginatedResponseResourceV1();

    // when
    petPaginatedResponseResourceValidator.validate(petPaginatedResponseResource);

    // then
  }
}
