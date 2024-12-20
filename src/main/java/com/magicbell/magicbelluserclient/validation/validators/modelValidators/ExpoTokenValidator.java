package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.ExpoToken;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

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
