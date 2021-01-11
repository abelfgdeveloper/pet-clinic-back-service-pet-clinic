package es.abelfgdeveloper.petclinic.petclinicservice.owner.util;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.CommonErrorCode;

public class OwnerErrorCode {

  private OwnerErrorCode() {}

  private static final String BASE_ERROR_CODE =
      CommonErrorCode.PET_CLINIC_ERROR_CODE
          + CommonErrorCode.PET_CLINIC_PET_CLINIC_SERVICE_ERROR_CODE;

  private static final String OWNER_BASE_ERROR_CODE = BASE_ERROR_CODE + "001";

  public static final String BODY_IS_MANDATORY = OWNER_BASE_ERROR_CODE + "001";
  public static final String ID_IS_MANDATORY = OWNER_BASE_ERROR_CODE + "002";
  public static final String FIRST_NAME_IS_MANDATORY = OWNER_BASE_ERROR_CODE + "003";
  public static final String LAST_NAME_IS_MANDATORY = OWNER_BASE_ERROR_CODE + "004";
  public static final String ADDRESS_IS_MANDATORY = OWNER_BASE_ERROR_CODE + "005";
  public static final String CITY_IS_MANDATORY = OWNER_BASE_ERROR_CODE + "006";
  public static final String TELEPHONE_IS_MANDATORY = OWNER_BASE_ERROR_CODE + "007";
  public static final String NOT_FOUND = OWNER_BASE_ERROR_CODE + "008";
}
