package es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import es.abelfgdeveloper.petclinic.petclinicservice.common.api.resource.response.ErrorResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetTypeObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.CreatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypeResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.model.entity.PetTypeEntity;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.util.PetTypeErrorCode;
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
class CreatePetTypeUseCaseTest extends CommonApiTest {

  private static final String BASE_ENDPOINT = "/v1/pet-types";

  @Test
  void test_create_ok() throws Exception {
    // given
    cleanDataBase();
    CreatePetTypeRequestResource request = PetTypeObjectMother.getCreatePetTypeRequestResourceV1();

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post(BASE_ENDPOINT)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .content(convertObjectToJsonAsString(request));
    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    PetTypeResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), PetTypeResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.CREATED, responseStatus);
    assertNotNull(response.getId());
    assertEquals(request.getName(), response.getName());

    // then validate the database
    PetTypeEntity petTypeEntity = petTypeRepository.findById(response.getId()).get();
    assertNotNull(petTypeEntity.getId());
    assertEquals(request.getName(), petTypeEntity.getName());
  }

  @Test
  void test_create_nameYetExist_ko() throws Exception {
    // given
    cleanDataBase();
    PetTypeEntity petType = petTypeRepository.save(PetTypeObjectMother.getPetTypeEntity());
    CreatePetTypeRequestResource request = PetTypeObjectMother.getCreatePetTypeRequestResourceV1();
    request.setName(petType.getName());

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post(BASE_ENDPOINT)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .content(convertObjectToJsonAsString(request));
    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    ErrorResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), ErrorResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.BAD_REQUEST, responseStatus);
    assertEquals(PetTypeErrorCode.NAME_YET_EXIST, response.getCode());
  }
}
