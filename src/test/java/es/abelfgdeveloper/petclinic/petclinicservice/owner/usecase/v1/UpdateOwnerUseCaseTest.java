package es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.OwnerObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.request.UpdateOwnerRequestResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.api.v1.resource.response.OwnerResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.model.entity.OwnerEntity;
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
class UpdateOwnerUseCaseTest extends CommonApiTest {

  private static final String BASE_ENDPOINT = "/v1/owners/{ownerId}";

  @Test
  void test_update_ok() throws Exception {
    // given
    cleanDataBase();
    OwnerEntity ownerInDataBase = ownerRepository.save(OwnerObjectMother.getOwnerEntity());
    UpdateOwnerRequestResource request = OwnerObjectMother.getUpdateOwnerRequestResourceV1();

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.put(BASE_ENDPOINT, ownerInDataBase.getId())
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .content(convertObjectToJsonAsString(request));
    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());
    OwnerResponseResource response =
        convertJsonAsStringToObject(
            mockHttpResponse.getContentAsString(), OwnerResponseResource.class);

    // then validate the response
    assertEquals(HttpStatus.OK, responseStatus);
    assertEquals(ownerInDataBase.getId(), response.getId());
    assertEquals(request.getFirstName(), response.getFirstName());
    assertEquals(request.getLastName(), response.getLastName());
    assertEquals(request.getAddress(), response.getAddress());
    assertEquals(request.getCity(), response.getCity());
    assertEquals(request.getTelephone(), response.getTelephone());

    // then validate the database
    OwnerEntity ownerEntity = ownerRepository.findById(response.getId()).get();
    assertEquals(ownerInDataBase.getId(), ownerEntity.getId());
    assertEquals(request.getFirstName(), ownerEntity.getFirstName());
    assertEquals(request.getLastName(), ownerEntity.getLastName());
    assertEquals(request.getAddress(), ownerEntity.getAddress());
    assertEquals(request.getCity(), ownerEntity.getCity());
    assertEquals(request.getTelephone(), ownerEntity.getTelephone());
  }
}
