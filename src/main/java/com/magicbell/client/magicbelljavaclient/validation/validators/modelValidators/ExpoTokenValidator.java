package com.magicbell.client.magicbelljavaclient.validation.validators.modelValidators;

import com.magicbell.client.magicbelljavaclient.models.ExpoToken;
import com.magicbell.client.magicbelljavaclient.validation.Violation;
import com.magicbell.client.magicbelljavaclient.validation.ViolationAggregator;
import com.magicbell.client.magicbelljavaclient.validation.validators.StringValidator;

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
