package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.validation;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.util.PetTypeErrorCode;
import org.springframework.util.StringUtils;

public abstract class PetTypeValidator {

  protected void validateId(String id) {
    if (!StringUtils.hasLength(id)) {
      throw new ValidationRequestException(PetTypeErrorCode.ID_IS_MANDATORY);
    }
  }

  protected void validateName(String name) {
    if (!StringUtils.hasLength(name)) {
      throw new ValidationRequestException(PetTypeErrorCode.NAME_IS_MANDATORY);
    }
  }
}
