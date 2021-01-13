package es.abelfgdeveloper.petclinic.petclinicservice.pet.mapper;

import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.Pet;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.model.entity.PetEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

  public Pet map(PetEntity pet) {
    return Pet.builder()
        .id(pet.getId())
        .name(pet.getName())
        .birthDate(pet.getBirthDate())
        .petTypeId(pet.getPetTypeId())
        .ownerId(pet.getOwnerId())
        .build();
  }

  public List<Pet> map(List<PetEntity> pets) {
    if (pets == null) {
      return new ArrayList<>();
    }
    return pets.stream().map(this::map).collect(Collectors.toList());
  }

  public PetEntity map(Pet pet) {
    return PetEntity.builder()
        .name(pet.getName())
        .birthDate(pet.getBirthDate())
        .petTypeId(pet.getPetTypeId())
        .ownerId(pet.getOwnerId())
        .build();
  }
}
