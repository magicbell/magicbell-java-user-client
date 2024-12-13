package com.magicbell.client.magicbelljavaclient.validation.validators.modelValidators;

import com.magicbell.client.magicbelljavaclient.models.ApnsToken;
import com.magicbell.client.magicbelljavaclient.validation.Violation;
import com.magicbell.client.magicbelljavaclient.validation.ViolationAggregator;
import com.magicbell.client.magicbelljavaclient.validation.validators.StringValidator;

public class ApnsTokenValidator extends AbstractModelValidator<ApnsToken> {

  public ApnsTokenValidator(String fieldName) {
    super(fieldName);
  }

  public ApnsTokenValidator() {}

  @Override
  protected Violation[] validateModel(ApnsToken apnsToken) {
    return new ViolationAggregator()
      .add(new StringValidator("deviceToken").minLength(64).required().validate(apnsToken.getDeviceToken()))
      .add(
        new StringValidator("appId").pattern("^[a-zA-Z0-9]+(.[a-zA-Z0-9]+)*$").optional().validate(apnsToken.getAppId())
      )
      .aggregate();
  }
}
