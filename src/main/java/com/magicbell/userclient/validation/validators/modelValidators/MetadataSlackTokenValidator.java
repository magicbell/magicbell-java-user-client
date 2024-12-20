package com.magicbell.userclient.validation.validators.modelValidators;

import com.magicbell.userclient.models.MetadataSlackToken;
import com.magicbell.userclient.validation.Violation;
import com.magicbell.userclient.validation.ViolationAggregator;

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
