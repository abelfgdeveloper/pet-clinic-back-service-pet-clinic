package es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import es.abelfgdeveloper.petclinic.petclinicservice.common.api.resource.response.ErrorResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetTypeObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypeResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.model.entity.PetTypeEntity;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.util.PetTypeErrorCode;
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
class FindPetTypeByIdUseCaseTest extends CommonApiTest {

  private static final String BASE_ENDPOINT = "/v1/pet-types/{petTypeId}";

  @Test
  void test_findById_ok() throws Exception {
    // given
    cleanDataBase();
    PetTypeEntity petTypeInDataBase =
        petTypeRepository.save(PetTypeObjectMother.getPetTypeEntity());

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(BASE_ENDPOINT, petTypeInDataBase.getId());

    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    PetTypeResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), PetTypeResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.OK, responseStatus);
    assertEquals(petTypeInDataBase.getId(), response.getId());
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
    assertEquals(PetTypeErrorCode.ID_NOT_FOUND, response.getCode());
  }
}
