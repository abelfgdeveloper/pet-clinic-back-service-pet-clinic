package es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.validation;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.ValidationRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.util.OwnerErrorCode;
import org.springframework.stereotype.Component;

@Component
public class CreateOwnerRequestResourceValidator extends OwnerValidator {

  public void validate(CreateOwnerRequestResource owner) {
    if (owner == null) {
      throw new ValidationRequestException(OwnerErrorCode.BODY_IS_MANDATORY);
    }

    validateFirstName(owner.getFirstName());
    validateLastName(owner.getLastName());
    validateAddress(owner.getAddress());
    validateCity(owner.getCity());
    validateTelephone(owner.getTelephone());
  }
}
