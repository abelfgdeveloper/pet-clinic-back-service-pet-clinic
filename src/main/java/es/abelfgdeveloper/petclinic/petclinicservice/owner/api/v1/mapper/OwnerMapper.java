package es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.mapper;

import es.abelfgdeveloper.petclinic.petclinicservice.common.mapper.PaginationMapper;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.Owner;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.OwnerPaginated;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("v1ResourceOwnerMapper")
public class OwnerMapper {

  private final PaginationMapper paginationMapper;

  public Owner map(CreateOwnerRequestResource owner) {
    return Owner.builder()
        .firstName(owner.getFirstName())
        .lastName(owner.getLastName())
        .address(owner.getAddress())
        .city(owner.getCity())
        .telephone(owner.getTelephone())
        .build();
  }

  public Owner map(UpdateOwnerRequestResource owner) {
    return Owner.builder()
        .firstName(owner.getFirstName())
        .lastName(owner.getLastName())
        .address(owner.getAddress())
        .city(owner.getCity())
        .telephone(owner.getTelephone())
        .build();
  }

  public OwnerResponseResource map(Owner owner) {
    return OwnerResponseResource.builder()
        .id(owner.getId())
        .firstName(owner.getFirstName())
        .lastName(owner.getLastName())
        .address(owner.getAddress())
        .city(owner.getCity())
        .telephone(owner.getTelephone())
        .build();
  }

  public OwnerPaginatedResponseResource map(OwnerPaginated ownerPaginated) {
    return OwnerPaginatedResponseResource.builder()
        .pagination(paginationMapper.map(ownerPaginated.getPagination()))
        .owners(ownerPaginated.getOwners().stream().map(this::map).collect(Collectors.toList()))
        .build();
  }
}
