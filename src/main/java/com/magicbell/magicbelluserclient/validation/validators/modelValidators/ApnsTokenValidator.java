package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.ApnsToken;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

/**
 * Validator implementation for ApnsToken model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ApnsTokenValidator extends AbstractModelValidator<ApnsToken> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ApnsTokenValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ApnsTokenValidator() {}

  /**
   * Validates the ApnsToken model's fields and constraints.
   *
   * @param apnsToken The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ApnsToken apnsToken) {
    return new ViolationAggregator()
      .add(new StringValidator("deviceToken").minLength(64).required().validate(apnsToken.getDeviceToken()))
      .add(
        new StringValidator("appId").pattern("^[a-zA-Z0-9]+(.[a-zA-Z0-9]+)*$").optional().validate(apnsToken.getAppId())
      )
      .aggregate();
  }
}
