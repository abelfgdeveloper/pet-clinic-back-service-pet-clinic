package es.abelfgdeveloper.petclinic.petclinicservice.pettype.model.repository;

import es.abelfgdeveloper.petclinic.petclinicservice.pettype.model.entity.PetTypeEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetTypeEntity, String> {

  Optional<PetTypeEntity> findByName(String name);
}
