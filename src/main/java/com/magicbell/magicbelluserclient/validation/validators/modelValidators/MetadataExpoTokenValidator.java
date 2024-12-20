package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.MetadataExpoToken;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;

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
