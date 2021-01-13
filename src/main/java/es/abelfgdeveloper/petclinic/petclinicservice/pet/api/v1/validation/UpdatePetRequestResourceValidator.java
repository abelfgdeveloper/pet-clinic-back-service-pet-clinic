package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.validation;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.UpdatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.util.PetErrorCode;
import org.springframework.stereotype.Component;

@Component
public class UpdatePetRequestResourceValidator extends PetValidator {

  public void validate(UpdatePetRequestResource pet) {
    if (pet == null) {
      throw new ValidationRequestException(PetErrorCode.BODY_IS_MANDATORY);
    }
    validateName(pet.getName());
    validateBirthDate(pet.getBirthDate());
  }
}
