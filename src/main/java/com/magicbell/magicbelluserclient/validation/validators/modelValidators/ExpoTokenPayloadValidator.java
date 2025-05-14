package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.ExpoTokenPayload;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

public class ExpoTokenPayloadValidator extends AbstractModelValidator<ExpoTokenPayload> {

  public ExpoTokenPayloadValidator(String fieldName) {
    super(fieldName);
  }

  public ExpoTokenPayloadValidator() {}

  @Override
  protected Violation[] validateModel(ExpoTokenPayload expoTokenPayload) {
    return new ViolationAggregator()
      .add(new StringValidator("deviceToken").minLength(1).required().validate(expoTokenPayload.getDeviceToken()))
      .aggregate();
  }
}
