package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.validation;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.server.ValidationResponseException;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypePaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypeResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.util.PetTypeErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PetTypePaginatedResponseResourceValidator extends PetTypeValidator {

  private final PetTypeResponseResourceValidator petTypeResponseResourceValidator;

  public void validate(PetTypePaginatedResponseResource petTypePaginated) {
    if (petTypePaginated == null) {
      throw new ValidationResponseException(PetTypeErrorCode.BODY_IS_MANDATORY);
    }
    for (PetTypeResponseResource petType : petTypePaginated.getPetTypes()) {
      petTypeResponseResourceValidator.validate(petType);
    }
  }
}
