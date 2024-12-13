package com.magicbell.client.magicbelljavaclient.validation.validators.modelValidators;

import com.magicbell.client.magicbelljavaclient.models.MetadataFcmToken;
import com.magicbell.client.magicbelljavaclient.validation.Violation;
import com.magicbell.client.magicbelljavaclient.validation.ViolationAggregator;

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
