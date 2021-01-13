package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response;

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
public class PetResponseResource {

  private String id;
  private String name;
  private LocalDate birthDate;
  private String petTypeId;
  private String ownerId;
}
