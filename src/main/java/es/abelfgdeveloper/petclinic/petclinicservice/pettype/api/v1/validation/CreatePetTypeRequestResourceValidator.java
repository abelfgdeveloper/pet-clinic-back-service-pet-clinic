package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.validation;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.CreatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.util.PetTypeErrorCode;
import org.springframework.stereotype.Component;

@Component
public class CreatePetTypeRequestResourceValidator extends PetTypeValidator {

  public void validate(CreatePetTypeRequestResource petType) {
    if (petType == null) {
      throw new ValidationRequestException(PetTypeErrorCode.BODY_IS_MANDATORY);
    }
    validateName(petType.getName());
  }
}
