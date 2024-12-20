package com.magicbell.userclient.validation.validators.modelValidators;

import com.magicbell.userclient.models.ExpoToken;
import com.magicbell.userclient.validation.Violation;
import com.magicbell.userclient.validation.ViolationAggregator;
import com.magicbell.userclient.validation.validators.StringValidator;

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
