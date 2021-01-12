package es.abelfgdeveloper.petclinic.petclinicservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.abelfgdeveloper.petclinic.petclinicservice.owner.model.repository.OwnerRepository;
import es.abelfgdeveloper.petclinic.petclinicservice.pettype.model.repository.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public abstract class CommonApiTest {

  @Autowired private ObjectMapper objectMapper;
  @Autowired protected MockMvc mvc;
  @Autowired protected OwnerRepository ownerRepository;
  @Autowired protected PetTypeRepository petTypeRepository;

  protected void cleanDataBase() {
    ownerRepository.deleteAll();
    petTypeRepository.deleteAll();
  }

  protected <T> T convertJsonAsStringToObject(String jsonAsString, Class<T> valueType)
      throws Exception {
    return objectMapper.readValue(jsonAsString, valueType);
  }

  protected String convertObjectToJsonAsString(Object content) throws Exception {
    return objectMapper.writeValueAsString(content);
  }
}
