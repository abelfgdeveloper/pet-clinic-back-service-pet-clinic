package es.abelfgdeveloper.petclinic.petclinicservice.common.api.resource.response;

import java.time.OffsetDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponseResource {

  private OffsetDateTime timestamp;
  private int status;
  private String error;
  private String message;
  private String code;
  private String detail;
  private List<String> stackTrace;
  private ErrorResponseResource cause;
}
