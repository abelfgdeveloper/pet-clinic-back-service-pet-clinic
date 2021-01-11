package es.abelfgdeveloper.petclinic.petclinicservice.common.config.exception;

import es.abelfgdeveloper.petclinic.petclinicservice.common.api.resource.response.ErrorResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.AbelfgDeveloperException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.mapper.StackTraceMapper;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RequiredArgsConstructor
@ControllerAdvice
@RestController
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

  private final StackTraceMapper stackTraceMapper;

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    if (ex instanceof AbelfgDeveloperException) {
      status = HttpStatus.valueOf(((AbelfgDeveloperException) ex).getStatus());
    }
    ErrorResponseResource errorResponseResource = handleResponseException(ex);
    errorResponseResource.setStatus(status.value());
    errorResponseResource.setError(status.getReasonPhrase());
    return new ResponseEntity<Object>(errorResponseResource, status);
  }

  private ErrorResponseResource handleResponseException(Exception ex) {
    if (ex == null) {
      return null;
    }

    return ErrorResponseResource.builder()
        .timestamp(LocalDateTime.now())
        .detail(ex.getClass().getSimpleName())
        .code(ex.getMessage())
        .stackTrace(stackTraceMapper.map(ex.getStackTrace()))
        .cause(handleResponseException((Exception) ex.getCause()))
        .build();
  }
}
