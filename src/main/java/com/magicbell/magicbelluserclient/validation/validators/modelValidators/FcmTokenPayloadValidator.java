package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.FcmTokenPayload;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

/**
 * Validator implementation for FcmTokenPayload model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class FcmTokenPayloadValidator extends AbstractModelValidator<FcmTokenPayload> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public FcmTokenPayloadValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public FcmTokenPayloadValidator() {}

  /**
   * Validates the FcmTokenPayload model's fields and constraints.
   *
   * @param fcmTokenPayload The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(FcmTokenPayload fcmTokenPayload) {
    return new ViolationAggregator()
      .add(new StringValidator("deviceToken").minLength(64).required().validate(fcmTokenPayload.getDeviceToken()))
      .aggregate();
  }
}
