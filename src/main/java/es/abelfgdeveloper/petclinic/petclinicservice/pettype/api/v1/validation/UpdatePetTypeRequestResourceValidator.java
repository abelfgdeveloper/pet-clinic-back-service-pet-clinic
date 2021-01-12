package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.validation;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.UpdatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.util.PetTypeErrorCode;
import org.springframework.stereotype.Component;

@Component
public class UpdatePetTypeRequestResourceValidator extends PetTypeValidator {

  public void validate(UpdatePetTypeRequestResource petType) {
    if (petType == null) {
      throw new ValidationRequestException(PetTypeErrorCode.BODY_IS_MANDATORY);
    }
    validateName(petType.getName());
  }
}
