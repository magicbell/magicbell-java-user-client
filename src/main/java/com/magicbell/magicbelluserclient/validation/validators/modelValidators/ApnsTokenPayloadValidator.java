package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.ApnsTokenPayload;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

/**
 * Validator implementation for ApnsTokenPayload model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ApnsTokenPayloadValidator extends AbstractModelValidator<ApnsTokenPayload> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ApnsTokenPayloadValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ApnsTokenPayloadValidator() {}

  /**
   * Validates the ApnsTokenPayload model's fields and constraints.
   *
   * @param apnsTokenPayload The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ApnsTokenPayload apnsTokenPayload) {
    return new ViolationAggregator()
      .add(new StringValidator("deviceToken").minLength(64).required().validate(apnsTokenPayload.getDeviceToken()))
      .add(
        new StringValidator("appId")
          .pattern("^[a-zA-Z0-9]+(.[a-zA-Z0-9]+)*$")
          .optional()
          .validate(apnsTokenPayload.getAppId())
      )
      .aggregate();
  }
}
