package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.MetadataSlackToken;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;

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
