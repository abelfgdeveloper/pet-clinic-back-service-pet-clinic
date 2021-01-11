package es.abelfgdeveloper.petclinic.petclinicservice.common.exception.server;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;

public class InternalServerException extends AbelfgDeveloperException {

  private static final long serialVersionUID = -3887393515002194939L;

  private static final int STATUS = 500;

  public InternalServerException(String errorCode) {
    super(STATUS, errorCode);
  }

  public InternalServerException(String errorCode, Throwable cause) {
    super(STATUS, errorCode, cause);
  }
}
