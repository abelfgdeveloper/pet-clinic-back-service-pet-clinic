package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.validation;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.BadRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.server.ValidationResponseException;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.util.PetErrorCode;
import org.springframework.stereotype.Component;

@Component
public class PetResponseResourceValidator extends PetValidator {

  public void validate(PetResponseResource pet) {
    if (pet == null) {
      throw new ValidationResponseException(PetErrorCode.BODY_IS_MANDATORY);
    }

    try {
      validateId(pet.getId());
      validateName(pet.getName());
      validateBirthDate(pet.getBirthDate());
      validatePetTypeId(pet.getPetTypeId());
      validateOwnerId(pet.getOwnerId());
    } catch (BadRequestException e) {
      throw new ValidationResponseException(e.getMessage(), e);
    }
  }
}
