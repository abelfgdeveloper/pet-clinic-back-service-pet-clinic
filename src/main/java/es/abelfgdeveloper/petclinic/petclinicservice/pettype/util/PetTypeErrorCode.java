package es.abelfgdeveloper.petclinic.petclinicservice.pettype.util;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.CommonErrorCode;

public class PetTypeErrorCode {

  private PetTypeErrorCode() {}

  private static final String BASE_ERROR_CODE =
      CommonErrorCode.PET_CLINIC_ERROR_CODE
          + CommonErrorCode.PET_CLINIC_PET_CLINIC_SERVICE_ERROR_CODE;

  private static final String PRT_TYPE_BASE_ERROR_CODE = BASE_ERROR_CODE + "002";

  public static final String BODY_IS_MANDATORY = PRT_TYPE_BASE_ERROR_CODE + "001";
  public static final String ID_IS_MANDATORY = PRT_TYPE_BASE_ERROR_CODE + "002";
  public static final String NAME_IS_MANDATORY = PRT_TYPE_BASE_ERROR_CODE + "003";
  public static final String NAME_YET_EXIST = PRT_TYPE_BASE_ERROR_CODE + "004";
  public static final String ID_NOT_FOUND = PRT_TYPE_BASE_ERROR_CODE + "005";
}
