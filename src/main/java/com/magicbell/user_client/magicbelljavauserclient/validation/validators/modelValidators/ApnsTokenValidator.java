package com.magicbell.user_client.magicbelljavauserclient.validation.validators.modelValidators;

import com.magicbell.user_client.magicbelljavauserclient.models.ApnsToken;
import com.magicbell.user_client.magicbelljavauserclient.validation.Violation;
import com.magicbell.user_client.magicbelljavauserclient.validation.ViolationAggregator;
import com.magicbell.user_client.magicbelljavauserclient.validation.validators.StringValidator;

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
