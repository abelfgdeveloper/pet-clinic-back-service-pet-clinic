package es.abelfgdeveloper.petclinic.petclinicservice.pet.usecase.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.api.v1.resource.response.PetPaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pet.model.entity.PetEntity;
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
class FindPetPaginatedUseCaseTest extends CommonApiTest {

  private static final String BASE_ENDPOINT = "/v1/pets";

  @Test
  void test_findById_ok() throws Exception {
    // given
    cleanDataBase();
    PetEntity petInDataBase = petRepository.save(PetObjectMother.getPetEntity());

    // when
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_ENDPOINT);

    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    PetPaginatedResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), PetPaginatedResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.OK, responseStatus);
    assertEquals(1, response.getPets().size());
    assertEquals(petInDataBase.getId(), response.getPets().get(0).getId());
  }
}
