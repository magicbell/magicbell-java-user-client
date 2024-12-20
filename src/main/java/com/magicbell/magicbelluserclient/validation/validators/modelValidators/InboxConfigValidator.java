package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.InboxConfig;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

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
