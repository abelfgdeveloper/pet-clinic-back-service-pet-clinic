package es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.validation;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.util.OwnerErrorCode;
import org.springframework.util.StringUtils;

public abstract class OwnerValidator {

  protected void validateId(String id) {
    if (!StringUtils.hasLength(id)) {
      throw new ValidationRequestException(OwnerErrorCode.ID_IS_MANDATORY);
    }
  }

  protected void validateFirstName(String firstName) {
    if (!StringUtils.hasLength(firstName)) {
      throw new ValidationRequestException(OwnerErrorCode.FIRST_NAME_IS_MANDATORY);
    }
  }

  protected void validateLastName(String lastName) {
    if (!StringUtils.hasLength(lastName)) {
      throw new ValidationRequestException(OwnerErrorCode.LAST_NAME_IS_MANDATORY);
    }
  }

  protected void validateAddress(String address) {
    if (!StringUtils.hasLength(address)) {
      throw new ValidationRequestException(OwnerErrorCode.ADDRESS_IS_MANDATORY);
    }
  }

  protected void validateCity(String city) {
    if (!StringUtils.hasLength(city)) {
      throw new ValidationRequestException(OwnerErrorCode.CITY_IS_MANDATORY);
    }
  }

  protected void validateTelephone(String telephone) {
    if (!StringUtils.hasLength(telephone)) {
      throw new ValidationRequestException(OwnerErrorCode.TELEPHONE_IS_MANDATORY);
    }
  }
}
