package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.InboxToken;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

public class InboxTokenValidator extends AbstractModelValidator<InboxToken> {

  public InboxTokenValidator(String fieldName) {
    super(fieldName);
  }

  public InboxTokenValidator() {}

  @Override
  protected Violation[] validateModel(InboxToken inboxToken) {
    return new ViolationAggregator()
      .add(new StringValidator("token").minLength(64).required().validate(inboxToken.getToken()))
      .aggregate();
  }
}
