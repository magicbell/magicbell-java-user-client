package com.magicbell.user_client.magicbelljavauserclient.validation.validators.modelValidators;

import com.magicbell.user_client.magicbelljavauserclient.models.FcmToken;
import com.magicbell.user_client.magicbelljavauserclient.validation.Violation;
import com.magicbell.user_client.magicbelljavauserclient.validation.ViolationAggregator;
import com.magicbell.user_client.magicbelljavauserclient.validation.validators.StringValidator;

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
