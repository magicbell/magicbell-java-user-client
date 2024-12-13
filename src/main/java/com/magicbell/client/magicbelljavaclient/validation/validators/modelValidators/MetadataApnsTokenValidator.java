package com.magicbell.client.magicbelljavaclient.validation.validators.modelValidators;

import com.magicbell.client.magicbelljavaclient.models.MetadataApnsToken;
import com.magicbell.client.magicbelljavaclient.validation.Violation;
import com.magicbell.client.magicbelljavaclient.validation.ViolationAggregator;

public class MetadataApnsTokenValidator extends AbstractModelValidator<MetadataApnsToken> {

  public MetadataApnsTokenValidator(String fieldName) {
    super(fieldName);
  }

  public MetadataApnsTokenValidator() {}

  @Override
  protected Violation[] validateModel(MetadataApnsToken metadataApnsToken) {
    return new ViolationAggregator()
      .add(new ApnsTokenValidator("data").required().validate(metadataApnsToken.getData()))
      .aggregate();
  }
}
