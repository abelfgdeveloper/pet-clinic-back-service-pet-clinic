package es.abelfgdeveloper.petclinic.petclinicservice.owner.model.repository;

import es.abelfgdeveloper.petclinic.petclinicservice.owner.model.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<OwnerEntity, String> {}
