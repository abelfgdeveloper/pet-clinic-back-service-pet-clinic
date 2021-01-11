package es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client;

public class ValidationRequestException extends BadRequestException {

  private static final long serialVersionUID = -6148136535714109724L;

  public ValidationRequestException(String errorCode) {
    super(errorCode);
  }

  public ValidationRequestException(String errorCode, Throwable cause) {
    super(errorCode, cause);
  }
}
