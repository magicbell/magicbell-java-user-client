package com.magicbell.userclient.validation.validators.modelValidators;

import com.magicbell.userclient.models.FcmToken;
import com.magicbell.userclient.validation.Violation;
import com.magicbell.userclient.validation.ViolationAggregator;
import com.magicbell.userclient.validation.validators.StringValidator;

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
