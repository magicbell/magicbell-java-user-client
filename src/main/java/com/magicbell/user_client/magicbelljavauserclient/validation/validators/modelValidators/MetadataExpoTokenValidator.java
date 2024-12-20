package com.magicbell.user_client.magicbelljavauserclient.validation.validators.modelValidators;

import com.magicbell.user_client.magicbelljavauserclient.models.MetadataExpoToken;
import com.magicbell.user_client.magicbelljavauserclient.validation.Violation;
import com.magicbell.user_client.magicbelljavauserclient.validation.ViolationAggregator;

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
