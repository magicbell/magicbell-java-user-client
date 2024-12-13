package com.magicbell.client.magicbelljavaclient.validation.validators.modelValidators;

import com.magicbell.client.magicbelljavaclient.models.InboxConfig;
import com.magicbell.client.magicbelljavaclient.validation.Violation;
import com.magicbell.client.magicbelljavaclient.validation.ViolationAggregator;
import com.magicbell.client.magicbelljavaclient.validation.validators.StringValidator;

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
