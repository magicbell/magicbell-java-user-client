package com.magicbell.user_client.magicbelljavauserclient.validation.validators.modelValidators;

import com.magicbell.user_client.magicbelljavauserclient.models.InboxConfig;
import com.magicbell.user_client.magicbelljavauserclient.validation.Violation;
import com.magicbell.user_client.magicbelljavauserclient.validation.ViolationAggregator;
import com.magicbell.user_client.magicbelljavauserclient.validation.validators.StringValidator;

public class InboxConfigValidator extends AbstractModelValidator<InboxConfig> {

  public InboxConfigValidator(String fieldName) {
    super(fieldName);
  }

  public InboxConfigValidator() {}

  @Override
  protected Violation[] validateModel(InboxConfig inboxConfig) {
    return new ViolationAggregator()
      .add(new StringValidator("locale").minLength(2).optional().validate(inboxConfig.getLocale()))
      .aggregate();
  }
}
