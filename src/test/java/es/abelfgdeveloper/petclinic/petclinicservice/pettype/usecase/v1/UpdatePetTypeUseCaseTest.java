package es.abelfgdeveloper.petclinic.petclinicservice.pettype.usecase.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.PetTypeObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.request.UpdatePetTypeRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.api.v1.resource.response.PetTypeResponseResource;
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
class UpdatePetTypeUseCaseTest extends CommonApiTest {

  private static final String BASE_ENDPOINT = "/v1/pet-types/{petTypeId}";

  @Test
  void test_update_ok() throws Exception {
    // given
    cleanDataBase();
    PetTypeEntity petTypeInDataBase =
        petTypeRepository.save(PetTypeObjectMother.getPetTypeEntity());
    UpdatePetTypeRequestResource request = PetTypeObjectMother.getUpdatePetTypeRequestResourceV1();

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put(BASE_ENDPOINT, petTypeInDataBase.getId())
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .content(convertObjectToJsonAsString(request));
    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    PetTypeResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), PetTypeResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.OK, responseStatus);
    assertEquals(petTypeInDataBase.getId(), response.getId());
    assertEquals(request.getName(), response.getName());

    // then validate the database
    PetTypeEntity petTypeEntity = petTypeRepository.findById(response.getId()).get();
    assertEquals(petTypeInDataBase.getId(), petTypeEntity.getId());
    assertEquals(request.getName(), petTypeEntity.getName());
  }
}
