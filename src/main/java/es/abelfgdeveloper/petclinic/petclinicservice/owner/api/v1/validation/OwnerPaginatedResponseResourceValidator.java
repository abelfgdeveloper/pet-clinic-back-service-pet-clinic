package es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.validation;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.server.ValidationResponseException;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.util.OwnerErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OwnerPaginatedResponseResourceValidator extends OwnerValidator {

  private final OwnerResponseResourceValidator ownerResponseResourceValidator;

  public void validate(OwnerPaginatedResponseResource owners) {
    if (owners == null) {
      throw new ValidationResponseException(OwnerErrorCode.BODY_IS_MANDATORY);
    }
    for (OwnerResponseResource owner : owners.getOwners()) {
      ownerResponseResourceValidator.validate(owner);
    }
  }
}
