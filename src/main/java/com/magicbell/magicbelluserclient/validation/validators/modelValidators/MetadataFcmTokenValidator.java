package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.MetadataFcmToken;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;

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
