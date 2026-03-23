package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.SlackTokenWebhook;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

/**
 * Validator implementation for SlackTokenWebhook model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class SlackTokenWebhookValidator extends AbstractModelValidator<SlackTokenWebhook> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public SlackTokenWebhookValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public SlackTokenWebhookValidator() {}

  /**
   * Validates the SlackTokenWebhook model's fields and constraints.
   *
   * @param slackTokenWebhook The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(SlackTokenWebhook slackTokenWebhook) {
    return new ViolationAggregator()
      .add(new StringValidator("url").minLength(1).required().validate(slackTokenWebhook.getUrl()))
      .aggregate();
  }
}
