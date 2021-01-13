package es.abelfgdeveloper.petclinic.petclinicservice.owner.service.impl;

import es.abelfgdeveloper.petclinic.petclinicservice.common.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.NotFoundException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.mapper.PaginationMapper;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.Owner;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.domain.OwnerPaginated;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.mapper.OwnerMapper;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.model.entity.OwnerEntity;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.model.repository.OwnerRepository;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.service.OwnerRepositoryService;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.util.OwnerErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultOwnerRepositoryService implements OwnerRepositoryService {

  private final OwnerRepository ownerRepository;

  private final OwnerMapper ownerMapper;
  private final PaginationMapper paginationMapper;

  @Override
  public Owner create(Owner owner) {
    return ownerMapper.map(ownerRepository.save(ownerMapper.map(owner)));
  }

  @Override
  public Owner update(String id, Owner owner) {
    OwnerEntity ownerInDataBase = find(id);
    ownerInDataBase.setFirstName(owner.getFirstName());
    ownerInDataBase.setLastName(owner.getLastName());
    ownerInDataBase.setAddress(owner.getAddress());
    ownerInDataBase.setCity(owner.getCity());
    ownerInDataBase.setTelephone(owner.getTelephone());
    return ownerMapper.map(ownerRepository.save(ownerInDataBase));
  }

  @Override
  public void deleteById(String id) {
    ownerRepository.delete(find(id));
    System.out.println();
  }

  @Override
  public Owner findById(String id) {
    return ownerMapper.map(find(id));
  }

  @Override
  public OwnerPaginated findAll(PaginationIn paginationIn) {
    Page<OwnerEntity> ownerPagination =
        ownerRepository.findAll(PageRequest.of(paginationIn.getPage(), paginationIn.getSize()));
    return OwnerPaginated.builder()
        .pagination(paginationMapper.map(ownerPagination))
        .owners(ownerMapper.map(ownerPagination.getContent()))
        .build();
  }

  private OwnerEntity find(String id) {
    return ownerRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException(OwnerErrorCode.NOT_FOUND));
  }
}
