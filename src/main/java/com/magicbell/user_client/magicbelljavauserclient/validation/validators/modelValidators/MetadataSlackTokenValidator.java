package com.magicbell.user_client.magicbelljavauserclient.validation.validators.modelValidators;

import com.magicbell.user_client.magicbelljavauserclient.models.MetadataSlackToken;
import com.magicbell.user_client.magicbelljavauserclient.validation.Violation;
import com.magicbell.user_client.magicbelljavauserclient.validation.ViolationAggregator;

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
