package es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.OwnerObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetTypeObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.model.entity.OwnerEntity;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.CreatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.model.entity.PetEntity;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.model.entity.PetTypeEntity;
import es.abelfgdeveloper.petclinic.petclinicservice.util.CommonApiTest;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureEmbeddedDatabase
@AutoConfigureMockMvc
class CreatePetUseCaseTest extends CommonApiTest {

  private static final String BASE_ENDPOINT = "/v1/pets";

  @Test
  void test_create_ok() throws Exception {
    // given
    cleanDataBase();
    OwnerEntity ownerEntity = ownerRepository.save(OwnerObjectMother.getOwnerEntity());
    PetTypeEntity petTypeEntity = petTypeRepository.save(PetTypeObjectMother.getPetTypeEntity());
    CreatePetRequestResource request = PetObjectMother.getCreatePetRequestResourceV1();
    request.setOwnerId(ownerEntity.getId());
    request.setPetTypeId(petTypeEntity.getId());

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post(BASE_ENDPOINT)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .content(convertObjectToJsonAsString(request));
    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    PetResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), PetResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.CREATED, responseStatus);
    assertNotNull(response.getId());
    assertEquals(request.getName(), response.getName());
    assertEquals(request.getBirthDate(), response.getBirthDate());
    assertEquals(request.getPetTypeId(), response.getPetTypeId());
    assertEquals(request.getOwnerId(), response.getOwnerId());

    // then validate the database
    PetEntity petEntity = petRepository.findById(response.getId()).get();
    assertNotNull(petEntity.getId());
    assertEquals(request.getName(), petEntity.getName());
    assertEquals(request.getBirthDate(), petEntity.getBirthDate());
    assertEquals(request.getPetTypeId(), petEntity.getPetTypeId());
    assertEquals(request.getOwnerId(), petEntity.getOwnerId());
  }
}
