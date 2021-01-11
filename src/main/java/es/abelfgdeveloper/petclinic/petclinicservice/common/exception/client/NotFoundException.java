package es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;

public class NotFoundException extends AbelfgDeveloperException {

  private static final long serialVersionUID = -266504147057372186L;

  private static final int STATUS = 404;

  public NotFoundException(String errorCode) {
    super(STATUS, errorCode);
  }

  public NotFoundException(String errorCode, Throwable cause) {
    super(STATUS, errorCode, cause);
  }
}
