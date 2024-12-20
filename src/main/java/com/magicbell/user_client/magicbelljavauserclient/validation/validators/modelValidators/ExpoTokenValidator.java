package com.magicbell.user_client.magicbelljavauserclient.validation.validators.modelValidators;

import com.magicbell.user_client.magicbelljavauserclient.models.ExpoToken;
import com.magicbell.user_client.magicbelljavauserclient.validation.Violation;
import com.magicbell.user_client.magicbelljavauserclient.validation.ViolationAggregator;
import com.magicbell.user_client.magicbelljavauserclient.validation.validators.StringValidator;

public class ExpoTokenValidator extends AbstractModelValidator<ExpoToken> {

  public ExpoTokenValidator(String fieldName) {
    super(fieldName);
  }

  public ExpoTokenValidator() {}

  @Override
  protected Violation[] validateModel(ExpoToken expoToken) {
    return new ViolationAggregator()
      .add(new StringValidator("deviceToken").minLength(1).required().validate(expoToken.getDeviceToken()))
      .aggregate();
  }
}
