package es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import es.abelfgdeveloper.petclinic.petclinicservice.common.api.v1.resource.response.ErrorResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.OwnerObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.model.entity.OwnerEntity;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.util.OwnerErrorCode;
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
class FindOwnerByIdUseCaseTest extends CommonApiTest {

  private static final String BASE_ENDPOINT = "/v1/owners/{ownerId}";

  @Test
  void test_findById_ok() throws Exception {
    // given
    cleanDataBase();
    OwnerEntity ownerInDataBase = ownerRepository.save(OwnerObjectMother.getOwnerEntity());

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(BASE_ENDPOINT, ownerInDataBase.getId());

    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    OwnerResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), OwnerResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.OK, responseStatus);
    assertEquals(ownerInDataBase.getId(), response.getId());
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
    assertEquals(OwnerErrorCode.NOT_FOUND, response.getCode());
  }
}
