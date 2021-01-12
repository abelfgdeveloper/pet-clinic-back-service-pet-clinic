package es.abelfgdeveloper.petclinic.petclinicservice.pettype.service.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.BadRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.NotFoundException;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetType;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.domain.PetTypePaginated;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.mapper.PetTypeMapper;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.model.entity.PetTypeEntity;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.model.repository.PetTypeRepository;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.service.PetTypeRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.util.PetTypeErrorCode;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultPetTypeRepositoryService implements PetTypeRepositoryService {

  private final PetTypeRepository petTypeRepository;

  private final PetTypeMapper petTypeMapper;

  @Override
  public PetType create(PetType petType) {
    validateNameNotExist(petType.getName());
    return petTypeMapper.map(petTypeRepository.save(petTypeMapper.map(petType)));
  }

  @Override
  public PetType update(String id, PetType petType) {
    PetTypeEntity petTypeInDataBase = find(id);
    validateNameNotExist(petType.getName());
    petTypeInDataBase.setName(petType.getName());
    return petTypeMapper.map(petTypeRepository.save(petTypeInDataBase));
  }

  @Override
  public void deleteById(String id) {
    petTypeRepository.delete(find(id));
  }

  @Override
  public PetType findById(String id) {
    return petTypeMapper.map(find(id));
  }

  @Override
  public PetTypePaginated findAll() {
    return PetTypePaginated.builder()
        .petTypes(
            petTypeRepository
                .findAll()
                .stream()
                .map(petTypeMapper::map)
                .collect(Collectors.toList()))
        .build();
  }

  private PetTypeEntity find(String id) {
    return petTypeRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException(PetTypeErrorCode.ID_NOT_FOUND));
  }

  private void validateNameNotExist(String name) {
    Optional<PetTypeEntity> petTypeInDataBase = petTypeRepository.findByName(name);
    if (petTypeInDataBase.isPresent()) {
      throw new BadRequestException(PetTypeErrorCode.NAME_YET_EXIST);
    }
  }
}
