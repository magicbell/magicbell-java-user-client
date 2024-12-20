package com.magicbell.user_client.magicbelljavauserclient.validation.validators.modelValidators;

import com.magicbell.user_client.magicbelljavauserclient.models.MetadataFcmToken;
import com.magicbell.user_client.magicbelljavauserclient.validation.Violation;
import com.magicbell.user_client.magicbelljavauserclient.validation.ViolationAggregator;

public class MetadataFcmTokenValidator extends AbstractModelValidator<MetadataFcmToken> {

  public MetadataFcmTokenValidator(String fieldName) {
    super(fieldName);
  }

  public MetadataFcmTokenValidator() {}

  @Override
  protected Violation[] validateModel(MetadataFcmToken metadataFcmToken) {
    return new ViolationAggregator()
      .add(new FcmTokenValidator("data").required().validate(metadataFcmToken.getData()))
      .aggregate();
  }
}
