
package com.magicbell.client.magicbelljavaclient.validation.validators.modelValidators;

import com.magicbell.client.magicbelljavaclient.models.WebPushStartInstallationResponse;
import com.magicbell.client.magicbelljavaclient.validation.Violation;
import com.magicbell.client.magicbelljavaclient.validation.ViolationAggregator;
import com.magicbell.client.magicbelljavaclient.validation.validators.StringValidator;

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
