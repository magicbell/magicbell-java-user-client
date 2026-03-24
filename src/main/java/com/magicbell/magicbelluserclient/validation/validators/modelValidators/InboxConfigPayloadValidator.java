package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.InboxConfigPayload;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

/**
 * Validator implementation for InboxConfigPayload model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class InboxConfigPayloadValidator extends AbstractModelValidator<InboxConfigPayload> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public InboxConfigPayloadValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public InboxConfigPayloadValidator() {}

  /**
   * Validates the InboxConfigPayload model's fields and constraints.
   *
   * @param inboxConfigPayload The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(InboxConfigPayload inboxConfigPayload) {
    return new ViolationAggregator()
      .add(new StringValidator("locale").minLength(2).optional().validate(inboxConfigPayload.getLocale()))
      .aggregate();
  }
}
