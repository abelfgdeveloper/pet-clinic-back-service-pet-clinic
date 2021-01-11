package es.abelfgdeveloper.petclinic.petclinicservice.common.exception;

import lombok.Getter;

@Getter
public class AbelfgDeveloperException extends RuntimeException {

  private static final long serialVersionUID = -7171207168790375225L;

  private final int status;

  public AbelfgDeveloperException(int status, String errorCode) {
    super(errorCode);
    this.status = status;
  }

  public AbelfgDeveloperException(int status, String errorCode, Throwable cause) {
    super(errorCode, cause);
    this.status = status;
  }
}
