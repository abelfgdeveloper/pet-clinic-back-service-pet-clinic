package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.validation;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.util.PetErrorCode;
import java.time.LocalDate;
import org.springframework.util.StringUtils;

public abstract class PetValidator {

  protected void validateId(String id) {
    if (!StringUtils.hasLength(id)) {
      throw new ValidationRequestException(PetErrorCode.ID_IS_MANDATORY);
    }
  }

  protected void validateName(String name) {
    if (!StringUtils.hasLength(name)) {
      throw new ValidationRequestException(PetErrorCode.NAME_IS_MANDATORY);
    }
  }

  protected void validateBirthDate(LocalDate birthDate) {
    if (birthDate == null) {
      throw new ValidationRequestException(PetErrorCode.BIRTH_DATE_IS_MANDATORY);
    }
  }

  protected void validatePetTypeId(String petTypeId) {
    if (!StringUtils.hasLength(petTypeId)) {
      throw new ValidationRequestException(PetErrorCode.PET_TYPE_ID_IS_MANDATORY);
    }
  }

  protected void validateOwnerId(String ownerId) {
    if (!StringUtils.hasLength(ownerId)) {
      throw new ValidationRequestException(PetErrorCode.OWNER_ID_IS_MANDATORY);
    }
  }
}
