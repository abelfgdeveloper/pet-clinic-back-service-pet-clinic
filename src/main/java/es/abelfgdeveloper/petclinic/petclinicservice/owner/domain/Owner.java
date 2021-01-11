package es.abelfgdeveloper.petclinic.petclinicservice.owner.domain;

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
public class Owner {

  @EqualsAndHashCode.Include private String id;
  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String telephone;
}
