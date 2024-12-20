package com.magicbell.userclient.validation.validators.modelValidators;

import com.magicbell.userclient.models.MetadataApnsToken;
import com.magicbell.userclient.validation.Violation;
import com.magicbell.userclient.validation.ViolationAggregator;

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
