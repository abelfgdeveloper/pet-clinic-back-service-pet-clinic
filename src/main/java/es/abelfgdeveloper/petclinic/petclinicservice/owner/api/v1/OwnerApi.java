package es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1;

import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request.CreateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerResponseResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/v1/owners")
public interface OwnerApi {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  OwnerResponseResource create(@RequestBody CreateOwnerRequestResource request);

  @PutMapping("/{ownerId}")
  @ResponseStatus(HttpStatus.OK)
  OwnerResponseResource update(
      @PathVariable("ownerId") String ownerId, @RequestBody UpdateOwnerRequestResource request);

  @DeleteMapping("/{ownerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deleteById(@PathVariable("ownerId") String ownerId);

  @GetMapping("/{ownerId}")
  @ResponseStatus(HttpStatus.OK)
  OwnerResponseResource findById(@PathVariable("ownerId") String ownerId);

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  OwnerPaginatedResponseResource findAll();
}
