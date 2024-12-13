package com.magicbell.client.magicbelljavaclient.validation.validators.modelValidators;

import com.magicbell.client.magicbelljavaclient.models.FcmToken;
import com.magicbell.client.magicbelljavaclient.validation.Violation;
import com.magicbell.client.magicbelljavaclient.validation.ViolationAggregator;
import com.magicbell.client.magicbelljavaclient.validation.validators.StringValidator;

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
