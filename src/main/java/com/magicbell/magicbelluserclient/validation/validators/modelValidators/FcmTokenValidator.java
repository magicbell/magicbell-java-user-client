package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.FcmToken;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

/**
 * Validator implementation for FcmToken model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class FcmTokenValidator extends AbstractModelValidator<FcmToken> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public FcmTokenValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public FcmTokenValidator() {}

  /**
   * Validates the FcmToken model's fields and constraints.
   *
   * @param fcmToken The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(FcmToken fcmToken) {
    return new ViolationAggregator()
      .add(new StringValidator("deviceToken").minLength(64).required().validate(fcmToken.getDeviceToken()))
      .aggregate();
  }
}
