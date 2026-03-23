package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.InboxTokenResponse;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

/**
 * Validator implementation for InboxTokenResponse model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class InboxTokenResponseValidator extends AbstractModelValidator<InboxTokenResponse> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public InboxTokenResponseValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public InboxTokenResponseValidator() {}

  /**
   * Validates the InboxTokenResponse model's fields and constraints.
   *
   * @param inboxTokenResponse The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(InboxTokenResponse inboxTokenResponse) {
    return new ViolationAggregator()
      .add(new StringValidator("token").minLength(64).required().validate(inboxTokenResponse.getToken()))
      .aggregate();
  }
}
