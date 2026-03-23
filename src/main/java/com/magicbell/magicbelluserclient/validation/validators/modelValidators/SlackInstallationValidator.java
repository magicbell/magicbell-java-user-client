package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.SlackInstallation;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

/**
 * Validator implementation for SlackInstallation model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class SlackInstallationValidator extends AbstractModelValidator<SlackInstallation> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public SlackInstallationValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public SlackInstallationValidator() {}

  /**
   * Validates the SlackInstallation model's fields and constraints.
   *
   * @param slackInstallation The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(SlackInstallation slackInstallation) {
    return new ViolationAggregator()
      .add(new StringValidator("id").pattern("^[A-Z0-9]+-.*$").optional().validate(slackInstallation.getId()))
      .aggregate();
  }
}
