package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.FcmTokenResponse;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

public class FcmTokenResponseValidator extends AbstractModelValidator<FcmTokenResponse> {

  public FcmTokenResponseValidator(String fieldName) {
    super(fieldName);
  }

  public FcmTokenResponseValidator() {}

  @Override
  protected Violation[] validateModel(FcmTokenResponse fcmTokenResponse) {
    return new ViolationAggregator()
      .add(new StringValidator("deviceToken").minLength(64).required().validate(fcmTokenResponse.getDeviceToken()))
      .aggregate();
  }
}
