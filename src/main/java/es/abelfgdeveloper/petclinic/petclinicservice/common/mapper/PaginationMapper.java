package es.abelfgdeveloper.petclinic.petclinicservice.common.mapper;

import es.abelfgdeveloper.petclinic.petclinicservice.common.api.v1.resource.response.PaginationResponseResource;
import es.abelfgdeveloper.petclinic.petclinicservice.common.domain.PaginationIn;
import es.abelfgdeveloper.petclinic.petclinicservice.common.domain.PaginationIn.PaginationInBuilder;
import es.abelfgdeveloper.petclinic.petclinicservice.common.domain.PaginationOut;
import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.client.BadRequestException;
import es.abelfgdeveloper.petclinic.petclinicservice.common.util.CommonErrorCode;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PaginationMapper {

  public PaginationIn map(Integer page, Integer size) {
    PaginationInBuilder paginationInBuilder = PaginationIn.builder();
    if (page == null) {
      paginationInBuilder.page(0);
    } else {
      validatePage(page);
      paginationInBuilder.page(page - 1);
    }
    if (size == null) {
      paginationInBuilder.size(10);
    } else {
      validatePageSize(size);
      paginationInBuilder.size(size);
    }
    return paginationInBuilder.build();
  }

  public PaginationOut map(Page<? extends Object> page) {
    return PaginationOut.builder()
        .page(page.getNumber() + 1)
        .size(page.getSize())
        .numberOfElements(page.getNumberOfElements())
        .totalPages(page.getTotalPages())
        .totalElements(page.getTotalElements())
        .first(page.isFirst())
        .last(page.isLast())
        .build();
  }

  public PaginationResponseResource map(PaginationOut pagination) {
    return PaginationResponseResource.builder()
        .page(pagination.getPage())
        .size(pagination.getSize())
        .numberOfElements(pagination.getNumberOfElements())
        .totalPages(pagination.getTotalPages())
        .totalElements(pagination.getTotalElements())
        .first(pagination.isFirst())
        .last(pagination.isLast())
        .build();
  }

  private void validatePage(Integer page) {
    if (page.intValue() == 0) {
      throw new BadRequestException(CommonErrorCode.PAGINATION_PAGE_LESS_THAN_0);
    }
  }

  private void validatePageSize(Integer size) {
    if (size.intValue() < 1) {
      throw new BadRequestException(CommonErrorCode.PAGINATION_SIZE_LESS_THAN_1);
    }
    if (size.intValue() > 50) {
      throw new BadRequestException(CommonErrorCode.PAGINATION_SIZE_MORE_THAN_50);
    }
  }
}
