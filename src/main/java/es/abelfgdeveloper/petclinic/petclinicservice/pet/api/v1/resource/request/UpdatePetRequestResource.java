package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpdatePetRequestResource {

  private String name;
  private LocalDate birthDate;
}
