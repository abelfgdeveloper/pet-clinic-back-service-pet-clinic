package es.abelfgdeveloper.petclinic.petclinicservice.pettype.mapper;

import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetType;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.model.entity.PetTypeEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class PetTypeMapper {

  public PetType map(PetTypeEntity petType) {
    return PetType.builder().id(petType.getId()).name(petType.getName()).build();
  }

  public PetTypeEntity map(PetType petType) {
    return PetTypeEntity.builder().name(petType.getName()).build();
  }

  public List<PetType> map(List<PetTypeEntity> petTypes) {
    if (petTypes == null) {
      return new ArrayList<>();
    }
    return petTypes.stream().map(this::map).collect(Collectors.toList());
  }
}
