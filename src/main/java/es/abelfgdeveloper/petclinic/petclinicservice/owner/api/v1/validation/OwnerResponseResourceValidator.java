package es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.validation;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.server.ValidationResponseException;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.util.OwnerErrorCode;
import org.springframework.stereotype.Component;

@Component
public class OwnerResponseResourceValidator extends OwnerValidator {

  public void validate(OwnerResponseResource owner) {

    if (owner == null) {
      throw new ValidationResponseException(OwnerErrorCode.BODY_IS_MANDATORY);
    }

    try {
      validateId(owner.getId());
      validateFirstName(owner.getFirstName());
      validateLastName(owner.getLastName());
      validateAddress(owner.getAddress());
      validateCity(owner.getCity());
      validateTelephone(owner.getTelephone());
    } catch (ValidationRequestException e) {
      throw new ValidationResponseException(e.getMessage(), e);
    }
  }
}
