package com.magicbell.client.magicbelljavaclient.validation.validators.modelValidators;

import com.magicbell.client.magicbelljavaclient.models.MetadataSlackToken;
import com.magicbell.client.magicbelljavaclient.validation.Violation;
import com.magicbell.client.magicbelljavaclient.validation.ViolationAggregator;

public class MetadataSlackTokenValidator extends AbstractModelValidator<MetadataSlackToken> {

  public MetadataSlackTokenValidator(String fieldName) {
    super(fieldName);
  }

  public MetadataSlackTokenValidator() {}

  @Override
  protected Violation[] validateModel(MetadataSlackToken metadataSlackToken) {
    return new ViolationAggregator()
      .add(new SlackTokenValidator("data").required().validate(metadataSlackToken.getData()))
      .aggregate();
  }
}
