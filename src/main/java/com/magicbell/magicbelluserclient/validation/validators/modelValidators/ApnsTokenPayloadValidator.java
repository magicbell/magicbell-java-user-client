package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.ApnsTokenPayload;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

public class ApnsTokenPayloadValidator extends AbstractModelValidator<ApnsTokenPayload> {

  public ApnsTokenPayloadValidator(String fieldName) {
    super(fieldName);
  }

  public ApnsTokenPayloadValidator() {}

  @Override
  protected Violation[] validateModel(ApnsTokenPayload apnsTokenPayload) {
    return new ViolationAggregator()
      .add(new StringValidator("deviceToken").minLength(64).required().validate(apnsTokenPayload.getDeviceToken()))
      .add(
        new StringValidator("appId")
          .pattern("^[a-zA-Z0-9]+(.[a-zA-Z0-9]+)*$")
          .optional()
          .validate(apnsTokenPayload.getAppId())
      )
      .aggregate();
  }
}
