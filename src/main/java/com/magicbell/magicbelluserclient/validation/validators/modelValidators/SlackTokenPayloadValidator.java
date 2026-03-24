package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.SlackTokenPayload;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;

/**
 * Validator implementation for SlackTokenPayload model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class SlackTokenPayloadValidator extends AbstractModelValidator<SlackTokenPayload> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public SlackTokenPayloadValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public SlackTokenPayloadValidator() {}

  /**
   * Validates the SlackTokenPayload model's fields and constraints.
   *
   * @param slackTokenPayload The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(SlackTokenPayload slackTokenPayload) {
    return new ViolationAggregator()
      .add(new SlackTokenPayloadWebhookValidator("webhook").optional().validate(slackTokenPayload.getWebhook()))
      .aggregate();
  }
}
