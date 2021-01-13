package es.abelfgdeveloper.petclinic.petclinicservice.pet.service;

import es.abelfgdeveloper.petclinic.petclinicservice.common.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.Pet;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.PetPaginated;

public interface PetRepositoryService {

  Pet create(Pet pet);

  Pet update(String id, Pet pet);

  void deleteById(String id);

  Pet findById(String id);

  PetPaginated findAll(PaginationIn pagination);
}
