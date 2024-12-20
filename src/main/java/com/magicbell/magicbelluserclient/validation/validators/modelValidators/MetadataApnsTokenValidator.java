package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.MetadataApnsToken;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;

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
