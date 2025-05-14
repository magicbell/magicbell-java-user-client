package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.FcmTokenPayload;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

public class FcmTokenPayloadValidator extends AbstractModelValidator<FcmTokenPayload> {

  public FcmTokenPayloadValidator(String fieldName) {
    super(fieldName);
  }

  public FcmTokenPayloadValidator() {}

  @Override
  protected Violation[] validateModel(FcmTokenPayload fcmTokenPayload) {
    return new ViolationAggregator()
      .add(new StringValidator("deviceToken").minLength(64).required().validate(fcmTokenPayload.getDeviceToken()))
      .aggregate();
  }
}
