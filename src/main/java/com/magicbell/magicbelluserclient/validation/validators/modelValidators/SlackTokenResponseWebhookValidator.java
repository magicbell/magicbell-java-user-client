package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.SlackTokenResponseWebhook;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

public class SlackTokenResponseWebhookValidator extends AbstractModelValidator<SlackTokenResponseWebhook> {

  public SlackTokenResponseWebhookValidator(String fieldName) {
    super(fieldName);
  }

  public SlackTokenResponseWebhookValidator() {}

  @Override
  protected Violation[] validateModel(SlackTokenResponseWebhook slackTokenResponseWebhook) {
    return new ViolationAggregator()
      .add(new StringValidator("url").minLength(1).required().validate(slackTokenResponseWebhook.getUrl()))
      .aggregate();
  }
}
