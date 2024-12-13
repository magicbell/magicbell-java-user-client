package com.magicbell.client.magicbelljavaclient.validation.validators.modelValidators;

import com.magicbell.client.magicbelljavaclient.models.MetadataExpoToken;
import com.magicbell.client.magicbelljavaclient.validation.Violation;
import com.magicbell.client.magicbelljavaclient.validation.ViolationAggregator;

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
