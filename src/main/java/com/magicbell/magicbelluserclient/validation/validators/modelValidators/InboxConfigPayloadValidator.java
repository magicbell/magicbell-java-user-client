package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.InboxConfigPayload;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

public class InboxConfigPayloadValidator extends AbstractModelValidator<InboxConfigPayload> {

  public InboxConfigPayloadValidator(String fieldName) {
    super(fieldName);
  }

  public InboxConfigPayloadValidator() {}

  @Override
  protected Violation[] validateModel(InboxConfigPayload inboxConfigPayload) {
    return new ViolationAggregator()
      .add(new StringValidator("locale").minLength(2).optional().validate(inboxConfigPayload.getLocale()))
      .aggregate();
  }
}
