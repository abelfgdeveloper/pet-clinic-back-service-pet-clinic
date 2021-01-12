package es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;

public class BadRequestException extends AbelfgDeveloperException {

  private static final long serialVersionUID = -7308539485155947345L;

  private static final int STATUS = 400;

  public BadRequestException(String errorCode) {
    super(STATUS, errorCode);
  }

  public BadRequestException(String errorCode, Throwable cause) {
    super(STATUS, errorCode, cause);
  }
}
