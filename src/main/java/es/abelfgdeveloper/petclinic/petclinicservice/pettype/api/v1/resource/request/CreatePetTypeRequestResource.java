package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request;

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
public class CreatePetTypeRequestResource {

  private String name;
}
