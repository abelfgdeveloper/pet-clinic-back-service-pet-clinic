package es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1;

import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.CreatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.UpdatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypePaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypeResponseResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/v1/pet-types")
public interface PetTypeApi {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  PetTypeResponseResource create(@RequestBody CreatePetTypeRequestResource request);

  @PutMapping("/{petTypeId}")
  @ResponseStatus(HttpStatus.OK)
  PetTypeResponseResource update(
      @PathVariable("petTypeId") String id, @RequestBody UpdatePetTypeRequestResource request);

  @DeleteMapping("/{petTypeId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deleteById(@PathVariable("petTypeId") String id);

  @GetMapping("/{petTypeId}")
  @ResponseStatus(HttpStatus.OK)
  PetTypeResponseResource findById(@PathVariable("petTypeId") String id);

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  PetTypePaginatedResponseResource findAll();
}
