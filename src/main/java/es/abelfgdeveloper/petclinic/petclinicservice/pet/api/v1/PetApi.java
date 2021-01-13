package es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1;

import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.CreatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.UpdatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetResponseResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/v1/pets")
public interface PetApi {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  PetResponseResource create(@RequestBody CreatePetRequestResource request);

  @PutMapping("/{petId}")
  @ResponseStatus(HttpStatus.OK)
  PetResponseResource update(
      @PathVariable("petId") String petId, @RequestBody UpdatePetRequestResource request);

  @DeleteMapping("/{petId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deleteById(@PathVariable("petId") String petId);

  @GetMapping("/{petId}")
  @ResponseStatus(HttpStatus.OK)
  PetResponseResource findById(@PathVariable("petId") String petId);

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  PetPaginatedResponseResource findAll();
}
