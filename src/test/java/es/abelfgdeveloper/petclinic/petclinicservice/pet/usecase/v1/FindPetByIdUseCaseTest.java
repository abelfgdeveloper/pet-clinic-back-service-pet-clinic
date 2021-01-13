package es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import es.abelfgdeveloper.petclinic.petclinicservice.common.api.v1.resource.response.ErrorResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.model.entity.PetEntity;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.util.PetErrorCode;
import es.abelfgdeveloper.petclinic.petclinicservice.util.CommonApiTest;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureEmbeddedDatabase
@AutoConfigureMockMvc
class FindPetByIdUseCaseTest extends CommonApiTest {

  private static final String BASE_ENDPOINT = "/v1/pets/{petId}";

  @Test
  void test_findById_ok() throws Exception {
    // given
    cleanDataBase();
    PetEntity petInDataBase = petRepository.save(PetObjectMother.getPetEntity());

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(BASE_ENDPOINT, petInDataBase.getId());

    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    PetResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), PetResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.OK, responseStatus);
    assertEquals(petInDataBase.getId(), response.getId());
  }

  @Test
  void test_findById_ko() throws Exception {
    // given
    cleanDataBase();
    String id = "a";

    // when
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_ENDPOINT, id);

    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    ErrorResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), ErrorResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.NOT_FOUND, responseStatus);
    assertEquals(PetErrorCode.ID_NOT_FOUND, response.getCode());
  }
}
