package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.validation;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.server.ValidationResponseException;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypeResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.util.PetTypeErrorCode;
import org.springframework.stereotype.Component;

@Component
public class PetTypeResponseResourceValidator extends PetTypeValidator {

  public void validate(PetTypeResponseResource petType) {
    if (petType == null) {
      throw new ValidationResponseException(PetTypeErrorCode.BODY_IS_MANDATORY);
    }

    try {
      validateId(petType.getId());
      validateName(petType.getName());
    } catch (ValidationRequestException e) {
      throw new ValidationResponseException(e.getMessage(), e);
    }
  }
}
