package es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetTypeObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypePaginatedResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.model.entity.PetTypeEntity;
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
class FindAllPetTypePaginatedUseCaseTest extends CommonApiTest {

  private static final String BASE_ENDPOINT = "/v1/pet-types";

  @Test
  void test_findById_ok() throws Exception {
    // given
    cleanDataBase();
    PetTypeEntity petTypeInDataBase =
        petTypeRepository.save(PetTypeObjectMother.getPetTypeEntity());

    // when
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(BASE_ENDPOINT);

    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    PetTypePaginatedResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), PetTypePaginatedResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.OK, responseStatus);
    assertEquals(1, response.getPetTypes().size());
    assertEquals(petTypeInDataBase.getId(), response.getPetTypes().get(0).getId());
  }
}
