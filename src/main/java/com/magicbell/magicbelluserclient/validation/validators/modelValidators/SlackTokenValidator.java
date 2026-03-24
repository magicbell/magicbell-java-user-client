package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.SlackToken;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;

/**
 * Validator implementation for SlackToken model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class SlackTokenValidator extends AbstractModelValidator<SlackToken> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public SlackTokenValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public SlackTokenValidator() {}

  /**
   * Validates the SlackToken model's fields and constraints.
   *
   * @param slackToken The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(SlackToken slackToken) {
    return new ViolationAggregator()
      .add(new SlackTokenWebhookValidator("webhook").optional().validate(slackToken.getWebhook()))
      .aggregate();
  }
}
