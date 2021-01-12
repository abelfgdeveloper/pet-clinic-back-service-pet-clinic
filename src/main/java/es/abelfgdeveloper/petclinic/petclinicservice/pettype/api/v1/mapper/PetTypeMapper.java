package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.mapper;

import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.CreatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.UpdatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypePaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypeResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetType;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetTypePaginated;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component("v1ResourcePetTypeMapper")
public class PetTypeMapper {

  public PetType map(CreatePetTypeRequestResource petType) {
    return PetType.builder().name(petType.getName()).build();
  }

  public PetType map(UpdatePetTypeRequestResource petType) {
    return PetType.builder().name(petType.getName()).build();
  }

  public PetTypeResponseResource map(PetType petType) {
    return PetTypeResponseResource.builder().id(petType.getId()).name(petType.getName()).build();
  }

  public PetTypePaginatedResponseResource map(PetTypePaginated petTypePaginated) {
    return PetTypePaginatedResponseResource.builder()
        .petTypes(
            petTypePaginated.getPetTypes().stream().map(this::map).collect(Collectors.toList()))
        .build();
  }
}
