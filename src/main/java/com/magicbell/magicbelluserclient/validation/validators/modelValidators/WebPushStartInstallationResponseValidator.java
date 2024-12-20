package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.WebPushStartInstallationResponse;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

public class WebPushStartInstallationResponseValidator
  extends AbstractModelValidator<WebPushStartInstallationResponse> {

  public WebPushStartInstallationResponseValidator(String fieldName) {
    super(fieldName);
  }

  public WebPushStartInstallationResponseValidator() {}

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
