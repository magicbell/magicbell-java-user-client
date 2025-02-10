package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.ExpoTokenResponse;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

public class ExpoTokenResponseValidator extends AbstractModelValidator<ExpoTokenResponse> {

  public ExpoTokenResponseValidator(String fieldName) {
    super(fieldName);
  }

  public ExpoTokenResponseValidator() {}

  @Override
  protected Violation[] validateModel(ExpoTokenResponse expoTokenResponse) {
    return new ViolationAggregator()
      .add(new StringValidator("deviceToken").minLength(1).required().validate(expoTokenResponse.getDeviceToken()))
      .aggregate();
  }
}
