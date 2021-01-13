package es.abelfgdeveloper.petclinic.petclinicservice.owner.service;

import es.abelfgdeveloper.petclinic.petclinicservice.common.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.Owner;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.OwnerPaginated;

public interface OwnerRepositoryService {

  Owner create(Owner owner);

  Owner update(String id, Owner owner);

  void deleteById(String id);

  Owner findById(String id);

  OwnerPaginated findAll(PaginationIn paginationIn);
}
