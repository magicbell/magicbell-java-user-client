package com.magicbell.magicbelluserclient.validation.validators.modelValidators;

import com.magicbell.magicbelluserclient.models.SlackTokenPayloadWebhook;
import com.magicbell.magicbelluserclient.validation.Violation;
import com.magicbell.magicbelluserclient.validation.ViolationAggregator;
import com.magicbell.magicbelluserclient.validation.validators.StringValidator;

public class SlackTokenPayloadWebhookValidator extends AbstractModelValidator<SlackTokenPayloadWebhook> {

  public SlackTokenPayloadWebhookValidator(String fieldName) {
    super(fieldName);
  }

  public SlackTokenPayloadWebhookValidator() {}

  @Override
  protected Violation[] validateModel(SlackTokenPayloadWebhook slackTokenPayloadWebhook) {
    return new ViolationAggregator()
      .add(new StringValidator("url").minLength(1).required().validate(slackTokenPayloadWebhook.getUrl()))
      .aggregate();
  }
}
