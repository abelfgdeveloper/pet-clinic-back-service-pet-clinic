package es.abelfgdeveloper.petclinic.petclinicservice.owner.usecase.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import es.abelfgdeveloper.petclinic.petclinicservice.objectmother.OwnerObjectMother;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.model.entity.OwnerEntity;
import es.abelfgdeveloper.petclinic.petclinicservice.util.CommonApiTest;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import java.util.Optional;
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
class DeleteOwnerByIdUseCaseTest extends CommonApiTest {

  private static final String BASE_ENDPOINT = "/v1/owners/{ownerId}";

  @Test
  void test_delete_ok() throws Exception {
    // given
    cleanDataBase();
    OwnerEntity ownerInDataBase = ownerRepository.save(OwnerObjectMother.getOwnerEntity());

    // when
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete(BASE_ENDPOINT, ownerInDataBase.getId());

    MockHttpServletResponse mockHttpResponse =
        mvc.perform(requestBuilder).andReturn().getResponse();

    HttpStatus responseStatus = HttpStatus.valueOf(mockHttpResponse.getStatus());

    // then validate the response
    assertEquals(HttpStatus.NO_CONTENT, responseStatus);

    // then validate the database
    Optional<OwnerEntity> ownerEntity = ownerRepository.findById(ownerInDataBase.getId());
    assertFalse(ownerEntity.isPresent());
  }
}
