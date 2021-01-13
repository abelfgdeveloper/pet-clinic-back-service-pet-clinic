package es.abelfgdeveloper.petclinic.petclinicservice.pet.service.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.NotFoundException;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.Pet;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.domain.PetPaginated;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.mapper.PetMapper;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.model.entity.PetEntity;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.model.repository.PetRepository;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.service.PetRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.util.PetErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultPetRepositoryService implements PetRepositoryService {

  private final PetRepository petRepository;
  private final PetMapper petMapper;

  @Override
  public Pet create(Pet pet) {
    return petMapper.map(petRepository.save(petMapper.map(pet)));
  }

  @Override
  public Pet update(String id, Pet pet) {
    PetEntity petInDataBase = find(id);
    petInDataBase.setName(pet.getName());
    petInDataBase.setBirthDate(pet.getBirthDate());
    return petMapper.map(petRepository.save(petInDataBase));
  }

  @Override
  public void deleteById(String id) {
    petRepository.delete(find(id));
  }

  @Override
  public Pet findById(String id) {
    return petMapper.map(find(id));
  }

  @Override
  public PetPaginated findAll() {
    return PetPaginated.builder().pets(petMapper.map(petRepository.findAll())).build();
  }

  private PetEntity find(String id) {
    return petRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException(PetErrorCode.ID_NOT_FOUND));
  }
}
