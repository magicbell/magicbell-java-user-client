package com.magicbell.userclient.validation.validators.modelValidators;

import com.magicbell.userclient.models.InboxConfig;
import com.magicbell.userclient.validation.Violation;
import com.magicbell.userclient.validation.ViolationAggregator;
import com.magicbell.userclient.validation.validators.StringValidator;

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
