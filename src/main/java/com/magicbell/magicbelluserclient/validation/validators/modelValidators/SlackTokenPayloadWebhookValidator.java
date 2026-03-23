package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.SlackTokenPayloadWebhook;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

/**
 * Validator implementation for SlackTokenPayloadWebhook model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class SlackTokenPayloadWebhookValidator extends AbstractModelValidator<SlackTokenPayloadWebhook> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public SlackTokenPayloadWebhookValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public SlackTokenPayloadWebhookValidator() {}

  /**
   * Validates the SlackTokenPayloadWebhook model's fields and constraints.
   *
   * @param slackTokenPayloadWebhook The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(SlackTokenPayloadWebhook slackTokenPayloadWebhook) {
    return new ViolationAggregator()
      .add(new StringValidator("url").minLength(1).required().validate(slackTokenPayloadWebhook.getUrl()))
      .aggregate();
  }
}
