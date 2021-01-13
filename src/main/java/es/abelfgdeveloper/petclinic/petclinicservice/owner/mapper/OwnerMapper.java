package es.abelfgdeveloper.petclinic.petclinicservice.owner.mapper;

import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.Owner;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.model.entity.OwnerEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {

  public OwnerEntity map(Owner owner) {
    return OwnerEntity.builder()
        .firstName(owner.getFirstName())
        .lastName(owner.getLastName())
        .address(owner.getAddress())
        .city(owner.getCity())
        .telephone(owner.getTelephone())
        .build();
  }

  public Owner map(OwnerEntity owner) {
    return Owner.builder()
        .id(owner.getId())
        .firstName(owner.getFirstName())
        .lastName(owner.getLastName())
        .address(owner.getAddress())
        .city(owner.getCity())
        .telephone(owner.getTelephone())
        .build();
  }

  public List<Owner> map(List<OwnerEntity> owners) {
    return owners.stream().map(this::map).collect(Collectors.toList());
  }
}
