package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.FcmToken;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

public class FcmTokenValidator extends AbstractModelValidator<FcmToken> {

  public FcmTokenValidator(String fieldName) {
    super(fieldName);
  }

  public FcmTokenValidator() {}

  @Override
  protected Violation[] validateModel(FcmToken fcmToken) {
    return new ViolationAggregator()
      .add(new StringValidator("deviceToken").minLength(64).required().validate(fcmToken.getDeviceToken()))
      .aggregate();
  }
}
