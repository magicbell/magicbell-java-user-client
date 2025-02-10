package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.ApnsTokenResponse;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

public class ApnsTokenResponseValidator extends AbstractModelValidator<ApnsTokenResponse> {

  public ApnsTokenResponseValidator(String fieldName) {
    super(fieldName);
  }

  public ApnsTokenResponseValidator() {}

  @Override
  protected Violation[] validateModel(ApnsTokenResponse apnsTokenResponse) {
    return new ViolationAggregator()
      .add(new StringValidator("deviceToken").minLength(64).required().validate(apnsTokenResponse.getDeviceToken()))
      .add(
        new StringValidator("appId")
          .pattern("^[a-zA-Z0-9]+(.[a-zA-Z0-9]+)*$")
          .optional()
          .validate(apnsTokenResponse.getAppId())
      )
      .aggregate();
  }
}
