package com.magicbell.user_client.magicbelljavauserclient.validation.validators.modelValidators;

import com.magicbell.user_client.magicbelljavauserclient.models.MetadataApnsToken;
import com.magicbell.user_client.magicbelljavauserclient.validation.Violation;
import com.magicbell.user_client.magicbelljavauserclient.validation.ViolationAggregator;

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
