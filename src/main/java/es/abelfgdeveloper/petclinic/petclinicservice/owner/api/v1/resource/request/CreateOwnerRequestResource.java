package es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request;

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
public class CreateOwnerRequestResource {

  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String telephone;
}
