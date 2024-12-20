package com.magicbell.userclient.validation.validators.modelValidators;

import com.magicbell.userclient.models.MetadataExpoToken;
import com.magicbell.userclient.validation.Violation;
import com.magicbell.userclient.validation.ViolationAggregator;

public class MetadataExpoTokenValidator extends AbstractModelValidator<MetadataExpoToken> {

  public MetadataExpoTokenValidator(String fieldName) {
    super(fieldName);
  }

  public MetadataExpoTokenValidator() {}

  @Override
  protected Violation[] validateModel(MetadataExpoToken metadataExpoToken) {
    return new ViolationAggregator()
      .add(new ExpoTokenValidator("data").required().validate(metadataExpoToken.getData()))
      .aggregate();
  }
}
