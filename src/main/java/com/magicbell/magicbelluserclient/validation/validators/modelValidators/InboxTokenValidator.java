package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.InboxToken;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

/**
 * Validator implementation for InboxToken model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class InboxTokenValidator extends AbstractModelValidator<InboxToken> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public InboxTokenValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public InboxTokenValidator() {}

  /**
   * Validates the InboxToken model's fields and constraints.
   *
   * @param inboxToken The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(InboxToken inboxToken) {
    return new ViolationAggregator()
      .add(new StringValidator("token").minLength(64).required().validate(inboxToken.getToken()))
      .aggregate();
  }
}
