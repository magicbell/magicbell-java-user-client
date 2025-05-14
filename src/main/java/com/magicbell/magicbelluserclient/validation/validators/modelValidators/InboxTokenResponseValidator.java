package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.InboxTokenResponse;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

public class InboxTokenResponseValidator extends AbstractModelValidator<InboxTokenResponse> {

  public InboxTokenResponseValidator(String fieldName) {
    super(fieldName);
  }

  public InboxTokenResponseValidator() {}

  @Override
  protected Violation[] validateModel(InboxTokenResponse inboxTokenResponse) {
    return new ViolationAggregator()
      .add(new StringValidator("token").minLength(64).required().validate(inboxTokenResponse.getToken()))
      .aggregate();
  }
}
