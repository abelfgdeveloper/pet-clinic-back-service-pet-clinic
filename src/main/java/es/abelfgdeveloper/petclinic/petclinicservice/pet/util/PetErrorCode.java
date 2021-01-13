package es.abelfgdeveloper.petclinic.petclinicservice.pet.util;

import es.abelfgdeveloper.petclinic.petclinicservice.common.exception.CommonErrorCode;

public class PetErrorCode {

  private PetErrorCode() {}

  private static final String BASE_ERROR_CODE =
      CommonErrorCode.PET_CLINIC_ERROR_CODE
          + CommonErrorCode.PET_CLINIC_PET_CLINIC_SERVICE_ERROR_CODE;

  private static final String PET_BASE_ERROR_CODE = BASE_ERROR_CODE + "003";

  public static final String BODY_IS_MANDATORY = PET_BASE_ERROR_CODE + "001";
  public static final String ID_IS_MANDATORY = PET_BASE_ERROR_CODE + "002";
  public static final String NAME_IS_MANDATORY = PET_BASE_ERROR_CODE + "003";
  public static final String BIRTH_DATE_IS_MANDATORY = PET_BASE_ERROR_CODE + "004";
  public static final String PET_TYPE_ID_IS_MANDATORY = PET_BASE_ERROR_CODE + "005";
  public static final String OWNER_ID_IS_MANDATORY = PET_BASE_ERROR_CODE + "006";
  public static final String ID_NOT_FOUND = PET_BASE_ERROR_CODE + "007";
  public static final String NAME_EXIST = PET_BASE_ERROR_CODE + "008";
}
