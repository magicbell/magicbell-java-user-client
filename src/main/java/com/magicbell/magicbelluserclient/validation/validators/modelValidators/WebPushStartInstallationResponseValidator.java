package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.WebPushStartInstallationResponse;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

/**
 * Validator implementation for WebPushStartInstallationResponse model.
 * Validates all fields and nested structures according to the model's constraints.
 */
public class WebPushStartInstallationResponseValidator
  extends AbstractModelValidator<WebPushStartInstallationResponse> {

  /**
   * Creates a validator with a field name for nested validation paths.
   *
   * @param fieldName The field name to use in violation paths
   */
  public WebPushStartInstallationResponseValidator(String fieldName) {
    super(fieldName);
  }

  /**
   * Creates a validator for root-level validation.
   */
  public WebPushStartInstallationResponseValidator() {}

  /**
   * Validates the WebPushStartInstallationResponse model's fields and constraints.
   *
   * @param webPushStartInstallationResponse The model instance to validate
   * @return Array of violations found during validation
   */
  @Override
  protected Violation[] validateModel(WebPushStartInstallationResponse webPushStartInstallationResponse) {
    return new ViolationAggregator()
      .add(
        new StringValidator("authToken")
          .minLength(8)
          .required()
          .validate(webPushStartInstallationResponse.getAuthToken())
      )
      .add(
        new StringValidator("publicKey")
          .minLength(8)
          .maxLength(128)
          .required()
          .validate(webPushStartInstallationResponse.getPublicKey())
      )
      .aggregate();
  }
}
