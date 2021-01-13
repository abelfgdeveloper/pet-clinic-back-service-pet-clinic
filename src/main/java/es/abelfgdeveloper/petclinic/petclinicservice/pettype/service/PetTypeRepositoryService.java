package es.abelfgdeveloper.petclinic.petclinicservice.pettype.service;

import es.abelfgdeveloper.petclinic.petclinicservice.common.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetType;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetTypePaginated;

public interface PetTypeRepositoryService {

  PetType create(PetType petType);

  PetType update(String id, PetType petType);

  void deleteById(String id);

  PetType findById(String id);

  PetTypePaginated findAll(PaginationIn paginationIn);
}
