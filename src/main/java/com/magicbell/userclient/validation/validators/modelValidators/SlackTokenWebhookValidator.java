package com.magicbell.userclient.validation.validators.modelValidators;

import com.magicbell.userclient.models.SlackTokenWebhook;
import com.magicbell.userclient.validation.Violation;
import com.magicbell.userclient.validation.ViolationAggregator;
import com.magicbell.userclient.validation.validators.StringValidator;

public class SlackTokenWebhookValidator extends AbstractModelValidator<SlackTokenWebhook> {

  public SlackTokenWebhookValidator(String fieldName) {
    super(fieldName);
  }

  public SlackTokenWebhookValidator() {}

  @Override
  protected Violation[] validateModel(SlackTokenWebhook slackTokenWebhook) {
    return new ViolationAggregator()
      .add(new StringValidator("url").minLength(1).required().validate(slackTokenWebhook.getUrl()))
      .aggregate();
  }
}
