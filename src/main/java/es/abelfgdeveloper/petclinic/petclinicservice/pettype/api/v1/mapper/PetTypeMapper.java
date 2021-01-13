package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.mapper;

import es.abelfgdeveloper.petclinic.petclinicservice.common.mapper.PaginationMapper;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.CreatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.UpdatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypePaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypeResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetType;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetTypePaginated;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("v1ResourcePetTypeMapper")
public class PetTypeMapper {

  private final PaginationMapper paginationMapper;

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
        .pagination(paginationMapper.map(petTypePaginated.getPagination()))
        .petTypes(
            petTypePaginated.getPetTypes().stream().map(this::map).collect(Collectors.toList()))
        .build();
  }
}
