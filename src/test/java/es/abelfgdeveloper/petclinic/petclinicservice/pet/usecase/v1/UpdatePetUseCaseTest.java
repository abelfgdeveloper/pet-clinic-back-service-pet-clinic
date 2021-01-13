package es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.request.UpdatePetRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.model.entity.PetEntity;
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
class UpdatePetUseCaseTest extends CommonApiTest {

  private static final String BASE_ENDPOINT = "/v1/pets/{petId}";

  @Test
  void test_update_ok() throws Exception {
    // given
    cleanDataBase();
    PetEntity petInDataBase = petRepository.save(PetObjectMother.getPetEntity());
    UpdatePetRequestResource request = PetObjectMother.getUpdatePetRequestResourceV1();

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put(BASE_ENDPOINT, petInDataBase.getId())
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .content(convertObjectToJsonAsString(request));
    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    PetResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), PetResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.OK, responseStatus);
    assertEquals(petInDataBase.getId(), response.getId());
    assertEquals(request.getName(), response.getName());
    assertEquals(request.getBirthDate(), response.getBirthDate());

    // then validate the database
    PetEntity petEntity = petRepository.findById(response.getId()).get();
    assertEquals(petInDataBase.getId(), petEntity.getId());
    assertEquals(request.getName(), petEntity.getName());
    assertEquals(request.getBirthDate(), petEntity.getBirthDate());
  }
}
