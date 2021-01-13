package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.validation;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.server.ValidationResponseException;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.util.PetErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PetPaginatedResponseResourceValidator extends PetValidator {

  private final PetResponseResourceValidator petResponseResourceValidator;

  public void validate(PetPaginatedResponseResource petPaginated) {
    if (petPaginated == null) {
      throw new ValidationResponseException(PetErrorCode.BODY_IS_MANDATORY);
    }
    for (PetResponseResource pet : petPaginated.getPets()) {
      petResponseResourceValidator.validate(pet);
    }
  }
}
