package es.abelfgdeveloper.petclinic.petclinicservice.pet.model.repository;

import es.abelfgdeveloper.petclinic.petclinicservice.pet.model.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetEntity, String> {}
