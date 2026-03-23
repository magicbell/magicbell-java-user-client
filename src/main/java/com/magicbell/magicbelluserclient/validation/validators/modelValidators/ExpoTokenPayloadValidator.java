package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.ExpoTokenPayload;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

/**
 * Validator implementation for ExpoTokenPayload model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class ExpoTokenPayloadValidator extends AbstractModelValidator<ExpoTokenPayload> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public ExpoTokenPayloadValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public ExpoTokenPayloadValidator() {}

  /**
   * Validates the ExpoTokenPayload model's fields and constraints.
   *
   * @param expoTokenPayload The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(ExpoTokenPayload expoTokenPayload) {
    return new ViolationAggregator()
      .add(new StringValidator("deviceToken").minLength(1).required().validate(expoTokenPayload.getDeviceToken()))
      .aggregate();
  }
}
