package es.abelfgdeveloper.petclinic.petclinicservice.pet.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Pet {

  @EqualsAndHashCode.Include private String id;
  private String name;
  private LocalDate birthDate;
  private String petTypeId;
  private String ownerId;
}
